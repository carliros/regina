Regina, A Registration System for Events
========================================

Author: Carlos Gomez
EMail: carliros.g at gmail dot com

To install the app
------------------

#. Install JBoss AS 7
#. Configure a DataSource for MySql and DataBase, 
   use this name for the jndi 'java:jboss/datasources/ReginaMySqlDS'
#. Deploy (command line):
    #. mvn clean package
    #. (jboss-cli) deploy $pathProject$/target/regina.war
#. Run the app
   http://localhost:8080/regina


To create the Datasource in JBoss-as-7
--------------------------------------

Firts you need a module for MySql, you already have, go to the next part.

#. In your jboss-home create the directory: jboss-home/modules/com/mysql/main
#. Copy the mysql conector to that directory.  You can use the conector 
   that is in the resources dir.
#. Copy the following content and name it "module.xml"

~~~
<module xmlns="urn:jboss:module:1.0" name="com.mysql">
   <resources>
     <resource-root path="mysql-connector-java-5.1.32-bin.jar"/>
   </resources>

   <dependencies>
      <module name="javax.api"/>
      <module name="javax.transaction.api"/>
    </dependencies>
</module>
~~~
#. Start the jboss server
#. Start the Management CLI (./jboss-cli.sh)
#. Connect to the server (connetc)
#. Execute the following command
~~~
/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.jdbc.jdbc2.optional.MysqlXADataSource)
~~~


Now, you create the Datasource.

#. Login into the server management
#. Click on "Add a data source"
#. Set a name, and a jndi (java:jboss/datasources/ReginaMySqlDS), select Mysql (your driver)
#. Setup the following data:
    * connection url: jdbc:mysql://localhost/regina
    * user/password
#. Enable the datasource and then try your connection by clicking at "Test connection"


You can get more information here: [JBoss Manual](https://docs.jboss.org/author/display/AS71/DataSource+configuration), or here [too](https://access.redhat.com/documentation/en-US/JBoss_Enterprise_Application_Platform/6/html-single/Administration_and_Configuration_Guide/index.html#Install_a_JDBC_Driver_as_a_Core_Module1).



