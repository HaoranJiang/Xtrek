
To use the satellite, please make sure that:

1.installed the latest u-blox GNSS Sensor Device Driver(See https://www.u-blox.com/en/product-resources?f%5B0%5D=property_file_product_filter%3A2779)
2.installed the latest u-blox VPC Device Driver(See https://www.u-blox.com/en/product-resources?f%5B0%5D=property_file_product_filter%3A2779)
3.Follow the instruction for installation. 
4.If it successed, go to Device Manager and check for "u-blox 7 GPS/GNSS Location Sensor" under "sensor" 
				and "u-blox Virtual COM Port" under "COM AND LPT"(Win 10 will be COM4)
5.Go to Settings->Privacy->Location and turn on the location service
6.Depending on which opeating system using(currently supports Windows(32/64),Linux, macos. Please replace the "rxtxSerial.dll" and "RXTXcomm.jar" 
  under /lib folder with these in Win32/64/Linux/Mac_OS_X.
7.Aftering building the project, there should be an executable named "Xtrek.jar" under /dist folder. To run the project, please copy the "rxtxSerial.dll" file
  in /lib folder and paste it in /dist folder. 
 Then in command line, type in 
 "java -jar Xtrek.jar"
 to run it.
				