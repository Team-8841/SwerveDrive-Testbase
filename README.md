# SwerveDrive Test

---
### Code borrowed and modified to work with our sensors from here:

[Video explaining the code](https://www.youtube.com/watch?v=0Xi9yb1IMyA)

[Github Repo](https://github.com/SeanSun6814/FRC0ToAutonomous/tree/master/%236%20Swerve%20Drive%20Auto)

---

### 3rd party libraries used in the code

[Rev API (SparkMax)](https://software-metadata.revrobotics.com/REVLib.json)


[Cross the road electronics API (Cancoder)](https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix-frc2022-latest.json)


[Kauailabs API (AHRS Gyro)](https://www.kauailabs.com/dist/frc/2022/navx_frc.json)

---

## How to setup

### CAN Bus
#### Spark Max
Connect to each spark max with the robot off using a usb-c cable (red ones in the tool box) and update the can ID for each of the motor controllers in the [REV Hardware Clent](https://docs.revrobotics.com/rev-hardware-client/getting-started/installation-instructions) 

When connected the software should look something like this
![alt text](https://2589213514-files.gitbook.io/~/files/v0/b/gitbook-legacy-files/o/assets%2F-MGEfA6CxjaSQiH5kHxn%2F-MQSqwQKU3AH0v050ufB%2F-MQSuzjcwEHLCWqGmz0F%2FHardware%20Tab%20-%20With%20CAN%20Bridge.svg?alt=media&token=f4de0218-ca60-4988-8abf-526ee2cac42e)
but you should only see 1 motor controller


Click on the motor controller and then you should see a bunch of settings pop up
![alt text](https://2589213514-files.gitbook.io/~/files/v0/b/gitbook-legacy-files/o/assets%2F-MGEfA6CxjaSQiH5kHxn%2F-MQSqwQKU3AH0v050ufB%2F-MQTX1fCPkxrfEozznPs%2FSPARK%20MAX%20-%20Basic.svg?alt=media&token=8e0492b7-ee97-4663-a532-f252b6ac6fe1)

Change the number in the ID field to the correct id found in the **Robot CAN Bus ID map** below

Once the id is set click on the **Burn Flash** button

Repeat for all Spark Max controllers.

#### Cancoder
Open the [Phoenix Framework Software](https://store.ctr-electronics.com/software/) and you should see this window
![alt text](https://docs.ctre-phoenix.com/en/stable/_images/tuner-2.png)

Turn on the robot and wait 10-30 seconds to allow the roborio to boot fully

Connect to the roborio via the USB type B port and click **Force Start Server** in the Phoenix software

Click on the **CAN Devices** tab and you should see all the devices connected to the CAN Bus
![alt text](https://docs.ctre-phoenix.com/en/stable/_images/tuner.png)

Now you will need to set the ID for each Cancoder 1 at a time since they are all new they come with the same default ID of 0

To change each ID 1 at a time you will need to isolate each CANCoder by disconnecting all from power but 1 at a time as you are chaning the ID

You may have to power down the robot between each CANCoder and repeat the steps to connect to protect the CANCoder from a short when disconnecting from power

To change an ID select the device you want to modify in the window

then in the bottom left of the window you will see the **General Device Configureation**

Set the ID to the correct ID found in the **Robot CAN Bus ID map** below and click the change ID button
![alt text](https://docs.ctre-phoenix.com/en/stable/_images/bring-3.png)

If operation completes, an OK will appear in the bottom status bar (this is true of all operations). Also note the ID has updated in the device list
![alt text](https://docs.ctre-phoenix.com/en/stable/_images/bring-4.png)

Once all the IDs are set for each of the CANCoders turn off the robot and reconnect all to power and turn the robot back on

Then you must update the firmware on each of the CANCoders downloaded from [Here](https://github.com/CrossTheRoadElec/Phoenix-Releases/blob/master/ctr-device-firmware.zip?raw=true)

extract the file from the zip file somewhere you will remember

To update the firmware select the device you want to update and then select the firmware file in the bottom left of the window then click update device.
You may get an option to update all devices of the same type if you do click that it will speed up the process

If the wrong CRF is selected (such as an original CANCoder crf for a CANCoder vH), Tuner will fail with CTRE_DI_InvalidCrfWrongProduct in the bottom right of the screen, and the text box will report “Selected CRF is for the wrong product”. A screenshot of this state is below.
![alt text](https://docs.ctre-phoenix.com/en/stable/_images/cancoder-vh-bad-firmware.png)

### Downloading the code
i will finish this later

---
### Robot CAN Bus ID map

| Module         | Turning motor           | Drive motor  | CANCoder |
| :-------------: |:-------------:| :-------------:| :-------------:|
| Front Left      | 1 | 2 | 3|
| Front Right      | 4 | 5 | 6|
| Rear Left      | 7 | 8 | 9|
| Rear Right      | 10 | 11 | 12|
---