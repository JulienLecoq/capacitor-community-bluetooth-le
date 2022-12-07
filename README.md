<p align="center"><br><img src="https://user-images.githubusercontent.com/236501/85893648-1c92e880-b7a8-11ea-926d-95355b8175c7.png" width="128" height="128" /></p>
<h3 align="center">Bluetooth Low Energy</h3>
<p align="center"><strong><code>@capacitor-community/bluetooth-le</code></strong></p>
<p align="center">
  Capacitor plugin for Bluetooth Low Energy 
</p>

<p align="center">
  <img src="https://img.shields.io/maintenance/yes/2022?style=flat-square" />
  <a href="https://github.com/capacitor-community/bluetooth-le/actions?query=workflow%3A%22CI%22"><img src="https://img.shields.io/github/workflow/status/capacitor-community/bluetooth-le/CI?style=flat-square" /></a>
  <a href="https://www.npmjs.com/package/@capacitor-community/bluetooth-le"><img src="https://img.shields.io/npm/l/@capacitor-community/bluetooth-le?style=flat-square" /></a>
<br>
  <a href="https://www.npmjs.com/package/@capacitor-community/bluetooth-le"><img src="https://img.shields.io/npm/dw/@capacitor-community/bluetooth-le?style=flat-square" /></a>
  <a href="https://www.npmjs.com/package/@capacitor-community/bluetooth-le"><img src="https://img.shields.io/npm/v/@capacitor-community/bluetooth-le?style=flat-square" /></a>
<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
<a href="#contributors-"><img src="https://img.shields.io/badge/all%20contributors-8-orange?style=flat-square" /></a>
<!-- ALL-CONTRIBUTORS-BADGE:END -->
</p>

## Maintainers

| Maintainer    | GitHub                              | Social |
| ------------- | ----------------------------------- | ------ |
| Patrick Wespi | [pwespi](https://github.com/pwespi) |        |

## Versions

| Plugin | Capacitor | Documentation                                                                     |
| ------ | --------- | --------------------------------------------------------------------------------- |
| 2.x    | 4.x       | [README](https://github.com/capacitor-community/bluetooth-le/blob/main/README.md) |
| 1.x    | 3.x       | [README](https://github.com/capacitor-community/bluetooth-le/blob/1.x/README.md)  |
| 0.x    | 2.x       | [README](https://github.com/capacitor-community/bluetooth-le/blob/0.x/README.md)  |

## Introduction

This is a Capacitor plugin for Bluetooth Low Energy. It supports the web, Android and iOS.

The goal is to support the same features on all platforms. Therefore the [Web Bluetooth API](https://developer.mozilla.org/en-US/docs/Web/API/Web_Bluetooth_API) is taken as a guidline for what features to implement.

This plugin only supports the central role of the Bluetooth Low Energy protocol. If you need the peripheral role, take a look a these plugins:

- https://github.com/randdusing/cordova-plugin-bluetoothle
- https://github.com/don/cordova-plugin-ble-peripheral

For support of Web Bluetooth in various browsers, see [implementation status](https://github.com/WebBluetoothCG/web-bluetooth/blob/main/implementation-status.md).

Below is an index of all the methods available.

<docgen-index>

- [`initialize(...)`](#initialize)
- [`isEnabled()`](#isenabled)
- [`forceEnable()`](#forceenable)
- [`disable()`](#disable)
- [`startEnabledNotifications(...)`](#startenablednotifications)
- [`stopEnabledNotifications()`](#stopenablednotifications)
- [`isLocationEnabled()`](#islocationenabled)
- [`openLocationSettings()`](#openlocationsettings)
- [`openBluetoothSettings()`](#openbluetoothsettings)
- [`openAppSettings()`](#openappsettings)
- [`setDisplayStrings(...)`](#setdisplaystrings)
- [`requestDevice(...)`](#requestdevice)
- [`requestLEScan(...)`](#requestlescan)
- [`stopLEScan()`](#stoplescan)
- [`getDevices(...)`](#getdevices)
- [`getConnectedDevices(...)`](#getconnecteddevices)
- [`connect(...)`](#connect)
- [`createBond(...)`](#createbond)
- [`isBonded(...)`](#isbonded)
- [`disconnect(...)`](#disconnect)
- [`getServices(...)`](#getservices)
- [`readRssi(...)`](#readrssi)
- [`read(...)`](#read)
- [`write(...)`](#write)
- [`writeWithoutResponse(...)`](#writewithoutresponse)
- [`readDescriptor(...)`](#readdescriptor)
- [`writeDescriptor(...)`](#writedescriptor)
- [`startNotifications(...)`](#startnotifications)
- [`stopNotifications(...)`](#stopnotifications)
- [`isInitialized()`](#isinitialized)
- [`hasPermissions()`](#haspermissions)
- [`checkPermissions()`](#checkpermissions)
- [`requestPermissions()`](#requestpermissions)
- [`enable()`](#enable)
- [`hasBluetoothScanPermission()`](#hasbluetoothscanpermission)
- [`hasBluetoothScanPermission()`](#hasbluetoothscanpermission)
- [`hasBluetoothConnectPermission()`](#hasbluetoothconnectpermission)
- [`hasAccessFineLocationPermission()`](#hasaccessfinelocationpermission)
- [`checkBluetoothPermission()`](#checkbluetoothpermission)
- [`checkBluetoothScanPermission()`](#checkbluetoothscanpermission)
- [`checkBluetoothConnectPermission()`](#checkbluetoothconnectpermission)
- [`checkAccessFineLocationPermission()`](#checkaccessfinelocationpermission)
- [`requestBluetoothPermission()`](#requestbluetoothpermission)
- [`requestBluetoothConnectPermission()`](#requestbluetoothconnectpermission)
- [`requestBluetoothScanPermission()`](#requestbluetoothscanpermission)
- [`requestAccessFineLocationPermission()`](#requestaccessfinelocationpermission)
- [`addListener('onEnabledChanged', ...)`](#addlisteneronenabledchanged)
- [`addListener('bluetoothStateChange', ...)`](#addlistenerbluetoothstatechange)
- [`addListener(string, ...)`](#addlistenerstring)
- [`addListener('onScanResult', ...)`](#addlisteneronscanresult)
- [Interfaces](#interfaces)
- [Type Aliases](#type-aliases)
- [Enums](#enums)

</docgen-index>

See [Platform Support](#platform-support) for an overview of supported methods on Android, iOS and web.

## Installation

```
npm install @capacitor-community/bluetooth-le
npx cap sync
```

### iOS

On iOS, add the `NSBluetoothAlwaysUsageDescription` to `Info.plist`, otherwise the app will crash when trying to use Bluetooth (see [here](https://developer.apple.com/documentation/corebluetooth)).

If the app needs to use Bluetooth while it is in the background, you also have to add `bluetooth-central` to `UIBackgroundModes` (for details see [here](https://developer.apple.com/documentation/bundleresources/information_property_list/uibackgroundmodes)).

`./ios/App/App/Info.plist`:

```diff
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
	<key>CFBundleDevelopmentRegion</key>
	<string>en</string>
  ...
+	<key>NSBluetoothAlwaysUsageDescription</key>
+	<string>Uses Bluetooth to connect and interact with peripheral BLE devices.</string>
+	<key>UIBackgroundModes</key>
+	<array>
+		<string>bluetooth-central</string>
+	</array>
</dict>
</plist>

```

### Android

On Android, no further steps are required to use the plugin (if you are using Capacitor 2, see [here](https://github.com/capacitor-community/bluetooth-le/blob/0.x/README.md#android)).

#### (Optional) Android 12 Bluetooth permissions

If your app targets Android 12 (API level 31) or higher and your app doesn't use Bluetooth scan results to derive physical location information, you can strongly assert that your app doesn't derive physical location. This allows the app to scan for Bluetooth devices without asking for location permissions. See the [Android documentation](https://developer.android.com/guide/topics/connectivity/bluetooth/permissions#declare-android12-or-higher).

The following steps are required to scan for Bluetooth devices without location permission on Android 12 devices:

- In `android/variables.gradle`, make sure `compileSdkVersion` and `targetSdkVersion` are at least 31 (changing those values can have other consequences on your app, so make sure you know what you're doing).
- Make sure you have JDK 11+ (it is recommended to use JDK that comes with Android Studio).
- In `android/app/src/main/AndroidManifest.xml`, add `android:exported="true"` to your activity if not already added (setting [`android:exported`](https://developer.android.com/guide/topics/manifest/activity-element#exported) is required in apps targeting Android 12 and higher).
- In `android/app/src/main/AndroidManifest.xml`, update the permissions:
  ```diff
      <!-- Permissions -->
  +   <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" android:maxSdkVersion="30" />
  +   <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" android:maxSdkVersion="30" />
  +   <uses-permission android:name="android.permission.BLUETOOTH_SCAN"
  +     android:usesPermissionFlags="neverForLocation"
  +     tools:targetApi="s" />
  ```
- Set the `androidNeverForLocation` flag to `true` when initializing the `BleClient`.
  ```ts
  import { BleClient } from '@capacitor-community/bluetooth-le';
  await BleClient.initialize({ androidNeverForLocation: true });
  ```

> [_Note_: If you include neverForLocation in your android:usesPermissionFlags, some BLE beacons are filtered from the scan results.](https://developer.android.com/guide/topics/connectivity/bluetooth/permissions#assert-never-for-location)

## Configuration

You can configure the strings that are displayed in the device selection dialog on iOS and Android when using `requestDevice()`:

`./capacitor.config.json`:

```JSON
{
  "...": "other configuration",
  "plugins": {
    "BluetoothLe": {
      "displayStrings": {
        "scanning": "Am Scannen...",
        "cancel": "Abbrechen",
        "availableDevices": "Verfügbare Geräte",
        "noDeviceFound": "Kein Gerät gefunden"
      }
    }
  }
}
```

The default values are:

```JSON
{
  "plugins": {
    "BluetoothLe": {
      "displayStrings": {
        "scanning": "Scanning...",
        "cancel": "Cancel",
        "availableDevices": "Available devices",
        "noDeviceFound": "No device found"
      }
    }
  }
}
```

The display strings can also be set at run-time using [`setDisplayStrings(...)`](#setdisplaystrings).

## Usage

It is recommended to not use the plugin class directly. There is a wrapper class `BleClient` which makes events and method arguments easier to work with.

```typescript
// Import the wrapper class directly
import { BleClient } from '@capacitor-community/bluetooth-le';

// DO NOT use this
import { BluetoothLe } from '@capacitor-community/bluetooth-le';
```

Here is an example of how to use the plugin. It shows how to read the heart rate from a BLE heart rate monitor such as the Polar H10.

```typescript
import { BleClient, numbersToDataView, numberToUUID } from '@capacitor-community/bluetooth-le';

const HEART_RATE_SERVICE = '0000180d-0000-1000-8000-00805f9b34fb';
const HEART_RATE_MEASUREMENT_CHARACTERISTIC = '00002a37-0000-1000-8000-00805f9b34fb';
const BODY_SENSOR_LOCATION_CHARACTERISTIC = '00002a38-0000-1000-8000-00805f9b34fb';
const BATTERY_SERVICE = numberToUUID(0x180f);
const BATTERY_CHARACTERISTIC = numberToUUID(0x2a19);
const POLAR_PMD_SERVICE = 'fb005c80-02e7-f387-1cad-8acd2d8df0c8';
const POLAR_PMD_CONTROL_POINT = 'fb005c81-02e7-f387-1cad-8acd2d8df0c8';

export async function main(): Promise<void> {
  try {
    await BleClient.initialize();

    const device = await BleClient.requestDevice({
      services: [HEART_RATE_SERVICE],
      optionalServices: [BATTERY_SERVICE, POLAR_PMD_SERVICE],
    });

    // connect to device, the onDisconnect callback is optional
    await BleClient.connect(device.deviceId, (deviceId) => onDisconnect(deviceId));
    console.log('connected to device', device);

    const result = await BleClient.read(device.deviceId, HEART_RATE_SERVICE, BODY_SENSOR_LOCATION_CHARACTERISTIC);
    console.log('body sensor location', result.getUint8(0));

    const battery = await BleClient.read(device.deviceId, BATTERY_SERVICE, BATTERY_CHARACTERISTIC);
    console.log('battery level', battery.getUint8(0));

    await BleClient.write(device.deviceId, POLAR_PMD_SERVICE, POLAR_PMD_CONTROL_POINT, numbersToDataView([1, 0]));
    console.log('written [1, 0] to control point');

    await BleClient.startNotifications(
      device.deviceId,
      HEART_RATE_SERVICE,
      HEART_RATE_MEASUREMENT_CHARACTERISTIC,
      (value) => {
        console.log('current heart rate', parseHeartRate(value));
      }
    );

    // disconnect after 10 sec
    setTimeout(async () => {
      await BleClient.stopNotifications(device.deviceId, HEART_RATE_SERVICE, HEART_RATE_MEASUREMENT_CHARACTERISTIC);
      await BleClient.disconnect(device.deviceId);
      console.log('disconnected from device', device);
    }, 10000);
  } catch (error) {
    console.error(error);
  }
}

function onDisconnect(deviceId: string): void {
  console.log(`device ${deviceId} disconnected`);
}

function parseHeartRate(value: DataView): number {
  const flags = value.getUint8(0);
  const rate16Bits = flags & 0x1;
  let heartRate: number;
  if (rate16Bits > 0) {
    heartRate = value.getUint16(1, true);
  } else {
    heartRate = value.getUint8(1);
  }
  return heartRate;
}
```

An example of using the scanning API:

```typescript
import { BleClient, numberToUUID } from '@capacitor-community/bluetooth-le';

const HEART_RATE_SERVICE = numberToUUID(0x180d);

export async function scan(): Promise<void> {
  try {
    await BleClient.initialize();

    await BleClient.requestLEScan(
      {
        services: [HEART_RATE_SERVICE],
      },
      (result) => {
        console.log('received new scan result', result);
      }
    );

    setTimeout(async () => {
      await BleClient.stopLEScan();
      console.log('stopped scanning');
    }, 5000);
  } catch (error) {
    console.error(error);
  }
}
```

## Example Applications

- [BLE Tester](https://github.com/sourcya/ble-tester) (Ionic/React)
- [OpenGoPro](https://github.com/gopro/OpenGoPro/tree/main/demos/ionic/file_transfer) (Ionic/Angular)
- [Quasar BLE](https://github.com/nunogois/quasar-ble) (Quasar/Vue)

## Platform Support

_Note_: web support depends on the browser, see [implementation status](https://github.com/WebBluetoothCG/web-bluetooth/blob/main/implementation-status.md).

| method                                                         | Android | iOS | web |
| -------------------------------------------------------------- | :-----: | :-: | :-: |
| [`initialize()`](#initialize)                                  |   ✅    | ✅  | ✅  |
| [`isEnabled()`](#isenabled)                                    |   ✅    | ✅  | --  |
| [`enable()`](#enable)                                          |   ✅    | ❌  | ❌  |
| [`disable()`](#disable)                                        |   ✅    | ❌  | ❌  |
| [`startEnabledNotifications(...)`](#startenablednotifications) |   ✅    | ✅  | --  |
| [`stopEnabledNotifications()`](#stopenablednotifications)      |   ✅    | ✅  | --  |
| [`isLocationEnabled()`](#islocationenabled)                    |   ✅    | ❌  | ❌  |
| [`openLocationSettings()`](#openlocationsettings)              |   ✅    | ❌  | ❌  |
| [`openBluetoothSettings()`](#openbluetoothsettings)            |   ✅    | ❌  | ❌  |
| [`openAppSettings()`](#openappsettings)                        |   ✅    | ✅  | ❌  |
| [`setDisplayStrings(...)`](#setdisplaystrings)                 |   ✅    | ✅  | --  |
| [`requestDevice(...)`](#requestdevice)                         |   ✅    | ✅  | ✅  |
| [`requestLEScan(...)`](#requestlescan)                         |   ✅    | ✅  | 🚩  |
| [`stopLEScan()`](#stoplescan)                                  |   ✅    | ✅  | 🚩  |
| [`getDevices(...)`](#getdevices)                               |   ✅    | ✅  | 🚩  |
| [`getConnectedDevices(...)`](#getconnecteddevices)             |   ✅    | ✅  | 🚩  |
| [`connect(...)`](#connect)                                     |   ✅    | ✅  | ✅  |
| [`createBond(...)`](#createbond)                               |   ✅    | ❌  | ❌  |
| [`isBonded(...)`](#isbonded)                                   |   ✅    | ❌  | ❌  |
| [`disconnect(...)`](#disconnect)                               |   ✅    | ✅  | ✅  |
| [`getServices(...)`](#getservices)                             |   ✅    | ✅  | ✅  |
| [`readRssi(...)`](#readrssi)                                   |   ✅    | ✅  | ❌  |
| [`read(...)`](#read)                                           |   ✅    | ✅  | ✅  |
| [`write(...)`](#write)                                         |   ✅    | ✅  | ✅  |
| [`readDescriptor(...)`](#read)                                 |   ✅    | ✅  | ✅  |
| [`writeDescriptor(...)`](#write)                               |   ✅    | ✅  | ✅  |
| [`writeWithoutResponse(...)`](#writewithoutresponse)           |   ✅    | ✅  | ✅  |
| [`startNotifications(...)`](#startnotifications)               |   ✅    | ✅  | ✅  |
| [`stopNotifications(...)`](#stopnotifications)                 |   ✅    | ✅  | ✅  |

#### Legend

- ✅ supported
- ❌ not supported (throws an `unavailable` error)
- 🚩 behind a flag in Chrome (see [implementation status](https://github.com/WebBluetoothCG/web-bluetooth/blob/main/implementation-status.md))
- -- not supported, but does not throw an error

## API

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### initialize(...)

```typescript
initialize(options?: InitializeOptions | undefined) => Promise<void>
```

Initialize Bluetooth Low Energy (BLE). If it fails, BLE might be unavailable on this device.
On **Android** it will ask for the location permission. On **iOS** it will ask for the Bluetooth permission.
For an example, see [usage](#usage).

| Param         | Type                                                            |
| ------------- | --------------------------------------------------------------- |
| **`options`** | <code><a href="#initializeoptions">InitializeOptions</a></code> |

---

### isEnabled()

```typescript
isEnabled() => Promise<boolean>
```

Reports whether Bluetooth is enabled on this device.
Always returns `true` on **web**.

**Returns:** <code>Promise&lt;boolean&gt;</code>

---

### forceEnable()

```typescript
forceEnable() => Promise<void>
```

Enable Bluetooth.
Only available on **Android**.

---

### disable()

```typescript
disable() => Promise<void>
```

Disable Bluetooth.
Only available on **Android**.

---

### startEnabledNotifications(...)

```typescript
startEnabledNotifications(callback: (value: boolean) => void) => Promise<void>
```

Register a callback function that will be invoked when Bluetooth is enabled (true) or disabled (false) on this device.
Not available on **web** (the callback will never be invoked).

| Param          | Type                                     | Description                                                |
| -------------- | ---------------------------------------- | ---------------------------------------------------------- |
| **`callback`** | <code>(value: boolean) =&gt; void</code> | Callback function to use when the Bluetooth state changes. |

---

### stopEnabledNotifications()

```typescript
stopEnabledNotifications() => Promise<void>
```

Stop the enabled notifications registered with `startEnabledNotifications`.

---

### isLocationEnabled()

```typescript
isLocationEnabled() => Promise<boolean>
```

Reports whether Location Services are enabled on this device.
Only available on **Android**.

**Returns:** <code>Promise&lt;boolean&gt;</code>

---

### openLocationSettings()

```typescript
openLocationSettings() => Promise<void>
```

Open Location settings.
Only available on **Android**.

---

### openBluetoothSettings()

```typescript
openBluetoothSettings() => Promise<void>
```

Open Bluetooth settings.
Only available on **Android**.

---

### openAppSettings()

```typescript
openAppSettings() => Promise<void>
```

Open App settings.
Not available on **web**.
On **iOS** when a user declines the request to use Bluetooth on the first call of `initialize`, it is not possible
to request for Bluetooth again from within the app. In this case Bluetooth has to be enabled in the app settings
for the app to be able use it.

---

### setDisplayStrings(...)

```typescript
setDisplayStrings(displayStrings: DisplayStrings) => Promise<void>
```

Set the strings that are displayed in the `requestDevice` dialog.

| Param                | Type                                                      |
| -------------------- | --------------------------------------------------------- |
| **`displayStrings`** | <code><a href="#displaystrings">DisplayStrings</a></code> |

---

### requestDevice(...)

```typescript
requestDevice(options?: RequestBleDeviceOptions | undefined) => Promise<BleDevice>
```

Request a peripheral BLE device to interact with. This will scan for available devices according to the filters in the options and show a dialog to pick a device.
For an example, see [usage](#usage).

| Param         | Type                                                                        | Description                                                             |
| ------------- | --------------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| **`options`** | <code><a href="#requestbledeviceoptions">RequestBleDeviceOptions</a></code> | Device filters, see [RequestBleDeviceOptions](#RequestBleDeviceOptions) |

**Returns:** <code>Promise&lt;<a href="#bledevice">BleDevice</a>&gt;</code>

---

### requestLEScan(...)

```typescript
requestLEScan(options: RequestBleDeviceOptions, callback: (result: ScanResult) => void) => Promise<void>
```

Start scanning for BLE devices to interact with according to the filters in the options. The callback will be invoked on each device that is found.
Scanning will continue until `stopLEScan` is called. For an example, see [usage](#usage).
**NOTE**: Use with care on **web** platform, the required API is still behind a flag in most browsers.

| Param          | Type                                                                        |
| -------------- | --------------------------------------------------------------------------- |
| **`options`**  | <code><a href="#requestbledeviceoptions">RequestBleDeviceOptions</a></code> |
| **`callback`** | <code>(result: <a href="#scanresult">ScanResult</a>) =&gt; void</code>      |

---

### stopLEScan()

```typescript
stopLEScan() => Promise<void>
```

Stop scanning for BLE devices. For an example, see [usage](#usage).

---

### getDevices(...)

```typescript
getDevices(deviceIds: string[]) => Promise<BleDevice[]>
```

On iOS and web, if you want to connect to a previously connected device without scanning first, you can use `getDevice`.
Uses [retrievePeripherals](https://developer.apple.com/documentation/corebluetooth/cbcentralmanager/1519127-retrieveperipherals) on iOS and
[getDevices](https://developer.mozilla.org/en-US/docs/Web/API/Bluetooth/getDevices) on web.
On Android, you can directly connect to the device with the deviceId.

| Param           | Type                  | Description                                                             |
| --------------- | --------------------- | ----------------------------------------------------------------------- |
| **`deviceIds`** | <code>string[]</code> | List of device IDs, e.g. saved from a previous app run. No used on web. |

**Returns:** <code>Promise&lt;BleDevice[]&gt;</code>

---

### getConnectedDevices(...)

```typescript
getConnectedDevices(services: string[]) => Promise<BleDevice[]>
```

Get a list of currently connected devices.
Uses [retrieveConnectedPeripherals](https://developer.apple.com/documentation/corebluetooth/cbcentralmanager/1518924-retrieveconnectedperipherals) on iOS,
[getConnectedDevices](<https://developer.android.com/reference/android/bluetooth/BluetoothManager#getConnectedDevices(int)>) on Android
and [getDevices](https://developer.mozilla.org/en-US/docs/Web/API/Bluetooth/getDevices) on web.

| Param          | Type                  | Description                                                                                                              |
| -------------- | --------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| **`services`** | <code>string[]</code> | List of services to filter the devices by. If no service is specified, no devices will be returned. Only applies to iOS. |

**Returns:** <code>Promise&lt;BleDevice[]&gt;</code>

---

### connect(...)

```typescript
connect(deviceId: string, onDisconnect?: ((deviceId: string) => void) | undefined, options?: TimeoutOptions | undefined) => Promise<void>
```

Connect to a peripheral BLE device. For an example, see [usage](#usage).

| Param              | Type                                                      | Description                                                                                                    |
| ------------------ | --------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| **`deviceId`**     | <code>string</code>                                       | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan)) |
| **`onDisconnect`** | <code>((deviceId: string) =&gt; void)</code>              | Optional disconnect callback function that will be used when the device disconnects                            |
| **`options`**      | <code><a href="#timeoutoptions">TimeoutOptions</a></code> | Options for plugin call                                                                                        |

---

### createBond(...)

```typescript
createBond(deviceId: string) => Promise<void>
```

Create a bond with a peripheral BLE device.
Only available on **Android**. On iOS bonding is handled by the OS.

| Param          | Type                | Description                                                                                                    |
| -------------- | ------------------- | -------------------------------------------------------------------------------------------------------------- |
| **`deviceId`** | <code>string</code> | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan)) |

---

### isBonded(...)

```typescript
isBonded(deviceId: string) => Promise<boolean>
```

Report whether a peripheral BLE device is bonded.
Only available on **Android**. On iOS bonding is handled by the OS.

| Param          | Type                | Description                                                                                                    |
| -------------- | ------------------- | -------------------------------------------------------------------------------------------------------------- |
| **`deviceId`** | <code>string</code> | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan)) |

**Returns:** <code>Promise&lt;boolean&gt;</code>

---

### disconnect(...)

```typescript
disconnect(deviceId: string) => Promise<void>
```

Disconnect from a peripheral BLE device. For an example, see [usage](#usage).

| Param          | Type                | Description                                                                                                    |
| -------------- | ------------------- | -------------------------------------------------------------------------------------------------------------- |
| **`deviceId`** | <code>string</code> | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan)) |

---

### getServices(...)

```typescript
getServices(deviceId: string) => Promise<BleService[]>
```

Get services, characteristics and descriptors of a device.

| Param          | Type                | Description                                                                                                    |
| -------------- | ------------------- | -------------------------------------------------------------------------------------------------------------- |
| **`deviceId`** | <code>string</code> | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan)) |

**Returns:** <code>Promise&lt;BleService[]&gt;</code>

---

### readRssi(...)

```typescript
readRssi(deviceId: string) => Promise<number>
```

Read the RSSI value of a connected device.
Not available on web.

| Param          | Type                | Description                                                                                                    |
| -------------- | ------------------- | -------------------------------------------------------------------------------------------------------------- |
| **`deviceId`** | <code>string</code> | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan)) |

**Returns:** <code>Promise&lt;number&gt;</code>

---

### read(...)

```typescript
read(deviceId: string, service: string, characteristic: string, options?: TimeoutOptions | undefined) => Promise<DataView>
```

Read the value of a characteristic. For an example, see [usage](#usage).

| Param                | Type                                                      | Description                                                                                                    |
| -------------------- | --------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| **`deviceId`**       | <code>string</code>                                       | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan)) |
| **`service`**        | <code>string</code>                                       | UUID of the service (see [UUID format](#uuid-format))                                                          |
| **`characteristic`** | <code>string</code>                                       | UUID of the characteristic (see [UUID format](#uuid-format))                                                   |
| **`options`**        | <code><a href="#timeoutoptions">TimeoutOptions</a></code> | Options for plugin call                                                                                        |

**Returns:** <code>Promise&lt;<a href="#dataview">DataView</a>&gt;</code>

---

### write(...)

```typescript
write(deviceId: string, service: string, characteristic: string, value: DataView, options?: TimeoutOptions | undefined) => Promise<void>
```

Write a value to a characteristic. For an example, see [usage](#usage).

| Param                | Type                                                      | Description                                                                                                                                                                                 |
| -------------------- | --------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`deviceId`**       | <code>string</code>                                       | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan))                                                                              |
| **`service`**        | <code>string</code>                                       | UUID of the service (see [UUID format](#uuid-format))                                                                                                                                       |
| **`characteristic`** | <code>string</code>                                       | UUID of the characteristic (see [UUID format](#uuid-format))                                                                                                                                |
| **`value`**          | <code><a href="#dataview">DataView</a></code>             | The value to write as a <a href="#dataview">DataView</a>. To create a <a href="#dataview">DataView</a> from an array of numbers, there is a helper function, e.g. numbersToDataView([1, 0]) |
| **`options`**        | <code><a href="#timeoutoptions">TimeoutOptions</a></code> | Options for plugin call                                                                                                                                                                     |

---

### writeWithoutResponse(...)

```typescript
writeWithoutResponse(deviceId: string, service: string, characteristic: string, value: DataView, options?: TimeoutOptions | undefined) => Promise<void>
```

Write a value to a characteristic without waiting for a response.

| Param                | Type                                                      | Description                                                                                                                                                                                 |
| -------------------- | --------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`deviceId`**       | <code>string</code>                                       | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan))                                                                              |
| **`service`**        | <code>string</code>                                       | UUID of the service (see [UUID format](#uuid-format))                                                                                                                                       |
| **`characteristic`** | <code>string</code>                                       | UUID of the characteristic (see [UUID format](#uuid-format))                                                                                                                                |
| **`value`**          | <code><a href="#dataview">DataView</a></code>             | The value to write as a <a href="#dataview">DataView</a>. To create a <a href="#dataview">DataView</a> from an array of numbers, there is a helper function, e.g. numbersToDataView([1, 0]) |
| **`options`**        | <code><a href="#timeoutoptions">TimeoutOptions</a></code> | Options for plugin call                                                                                                                                                                     |

---

### readDescriptor(...)

```typescript
readDescriptor(deviceId: string, service: string, characteristic: string, descriptor: string, options?: TimeoutOptions | undefined) => Promise<DataView>
```

Read the value of a descriptor.

| Param                | Type                                                      | Description                                                                                                    |
| -------------------- | --------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| **`deviceId`**       | <code>string</code>                                       | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan)) |
| **`service`**        | <code>string</code>                                       | UUID of the service (see [UUID format](#uuid-format))                                                          |
| **`characteristic`** | <code>string</code>                                       | UUID of the characteristic (see [UUID format](#uuid-format))                                                   |
| **`descriptor`**     | <code>string</code>                                       | UUID of the descriptor (see [UUID format](#uuid-format))                                                       |
| **`options`**        | <code><a href="#timeoutoptions">TimeoutOptions</a></code> | Options for plugin call                                                                                        |

**Returns:** <code>Promise&lt;<a href="#dataview">DataView</a>&gt;</code>

---

### writeDescriptor(...)

```typescript
writeDescriptor(deviceId: string, service: string, characteristic: string, descriptor: string, value: DataView, options?: TimeoutOptions | undefined) => Promise<void>
```

Write a value to a descriptor.

| Param                | Type                                                      | Description                                                                                                                                                                                 |
| -------------------- | --------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`deviceId`**       | <code>string</code>                                       | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan))                                                                              |
| **`service`**        | <code>string</code>                                       | UUID of the service (see [UUID format](#uuid-format))                                                                                                                                       |
| **`characteristic`** | <code>string</code>                                       | UUID of the characteristic (see [UUID format](#uuid-format))                                                                                                                                |
| **`descriptor`**     | <code>string</code>                                       | UUID of the descriptor (see [UUID format](#uuid-format))                                                                                                                                    |
| **`value`**          | <code><a href="#dataview">DataView</a></code>             | The value to write as a <a href="#dataview">DataView</a>. To create a <a href="#dataview">DataView</a> from an array of numbers, there is a helper function, e.g. numbersToDataView([1, 0]) |
| **`options`**        | <code><a href="#timeoutoptions">TimeoutOptions</a></code> | Options for plugin call                                                                                                                                                                     |

---

### startNotifications(...)

```typescript
startNotifications(deviceId: string, service: string, characteristic: string, callback: (value: DataView) => void) => Promise<void>
```

Start listening to changes of the value of a characteristic.
Note that you should only start the notifications once per characteristic in your app and share the data and
not call `startNotifications` in every component that needs the data.
For an example, see [usage](#usage).

| Param                | Type                                                              | Description                                                                                                    |
| -------------------- | ----------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| **`deviceId`**       | <code>string</code>                                               | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan)) |
| **`service`**        | <code>string</code>                                               | UUID of the service (see [UUID format](#uuid-format))                                                          |
| **`characteristic`** | <code>string</code>                                               | UUID of the characteristic (see [UUID format](#uuid-format))                                                   |
| **`callback`**       | <code>(value: <a href="#dataview">DataView</a>) =&gt; void</code> | Callback function to use when the value of the characteristic changes                                          |

---

### stopNotifications(...)

```typescript
stopNotifications(deviceId: string, service: string, characteristic: string) => Promise<void>
```

Stop listening to the changes of the value of a characteristic. For an example, see [usage](#usage).

| Param                | Type                | Description                                                                                                    |
| -------------------- | ------------------- | -------------------------------------------------------------------------------------------------------------- |
| **`deviceId`**       | <code>string</code> | The ID of the device to use (obtained from [requestDevice](#requestDevice) or [requestLEScan](#requestLEScan)) |
| **`service`**        | <code>string</code> | UUID of the service (see [UUID format](#uuid-format))                                                          |
| **`characteristic`** | <code>string</code> | UUID of the characteristic (see [UUID format](#uuid-format))                                                   |

---

### isInitialized()

```typescript
isInitialized() => Promise<boolean>
```

Reports whether Bluetooth is initialized.
Not available on **web**.

**Returns:** <code>Promise&lt;boolean&gt;</code>

---

### hasPermissions()

```typescript
hasPermissions() => Promise<boolean>
```

Reports whether Bluetooth permissions have been granted.
Not available on **web**.

**Returns:** <code>Promise&lt;boolean&gt;</code>

---

### checkPermissions()

```typescript
checkPermissions() => Promise<PermissionStatus>
```

Reports whether the state of the permissions.
Not available on **web**.

**Returns:** <code>Promise&lt;<a href="#permissionstatus">PermissionStatus</a>&gt;</code>

---

### requestPermissions()

```typescript
requestPermissions() => Promise<PermissionStatus>
```

Request the permissions.
Not available on **web**.

**Returns:** <code>Promise&lt;<a href="#permissionstatus">PermissionStatus</a>&gt;</code>

---

### enable()

```typescript
enable() => Promise<boolean>
```

**Returns:** <code>Promise&lt;boolean&gt;</code>

---

### hasBluetoothScanPermission()

```typescript
hasBluetoothScanPermission() => Promise<boolean>
```

**Returns:** <code>Promise&lt;boolean&gt;</code>

---

### hasBluetoothScanPermission()

```typescript
hasBluetoothScanPermission() => Promise<boolean>
```

**Returns:** <code>Promise&lt;boolean&gt;</code>

---

### hasBluetoothConnectPermission()

```typescript
hasBluetoothConnectPermission() => Promise<boolean>
```

**Returns:** <code>Promise&lt;boolean&gt;</code>

---

### hasAccessFineLocationPermission()

```typescript
hasAccessFineLocationPermission() => Promise<boolean>
```

**Returns:** <code>Promise&lt;boolean&gt;</code>

---

### checkBluetoothPermission()

```typescript
checkBluetoothPermission() => Promise<PermissionState>
```

**Returns:** <code>Promise&lt;<a href="#permissionstate">PermissionState</a>&gt;</code>

---

### checkBluetoothScanPermission()

```typescript
checkBluetoothScanPermission() => Promise<PermissionState>
```

**Returns:** <code>Promise&lt;<a href="#permissionstate">PermissionState</a>&gt;</code>

---

### checkBluetoothConnectPermission()

```typescript
checkBluetoothConnectPermission() => Promise<PermissionState>
```

**Returns:** <code>Promise&lt;<a href="#permissionstate">PermissionState</a>&gt;</code>

---

### checkAccessFineLocationPermission()

```typescript
checkAccessFineLocationPermission() => Promise<PermissionState>
```

**Returns:** <code>Promise&lt;<a href="#permissionstate">PermissionState</a>&gt;</code>

---

### requestBluetoothPermission()

```typescript
requestBluetoothPermission() => Promise<PermissionState>
```

**Returns:** <code>Promise&lt;<a href="#permissionstate">PermissionState</a>&gt;</code>

---

### requestBluetoothConnectPermission()

```typescript
requestBluetoothConnectPermission() => Promise<PermissionState>
```

**Returns:** <code>Promise&lt;<a href="#permissionstate">PermissionState</a>&gt;</code>

---

### requestBluetoothScanPermission()

```typescript
requestBluetoothScanPermission() => Promise<PermissionState>
```

**Returns:** <code>Promise&lt;<a href="#permissionstate">PermissionState</a>&gt;</code>

---

### requestAccessFineLocationPermission()

```typescript
requestAccessFineLocationPermission() => Promise<PermissionState>
```

**Returns:** <code>Promise&lt;<a href="#permissionstate">PermissionState</a>&gt;</code>

---

### addListener('onEnabledChanged', ...)

```typescript
addListener(eventName: 'onEnabledChanged', listenerFunc: (result: BooleanResult) => void) => PluginListenerHandle
```

| Param              | Type                                                                         |
| ------------------ | ---------------------------------------------------------------------------- |
| **`eventName`**    | <code>'onEnabledChanged'</code>                                              |
| **`listenerFunc`** | <code>(result: <a href="#booleanresult">BooleanResult</a>) =&gt; void</code> |

**Returns:** <code><a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

---

### addListener('bluetoothStateChange', ...)

```typescript
addListener(eventName: 'bluetoothStateChange', listenerFunc: (result: IsActiveResult) => void) => PluginListenerHandle
```

| Param              | Type                                                                           |
| ------------------ | ------------------------------------------------------------------------------ |
| **`eventName`**    | <code>'bluetoothStateChange'</code>                                            |
| **`listenerFunc`** | <code>(result: <a href="#isactiveresult">IsActiveResult</a>) =&gt; void</code> |

**Returns:** <code><a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

---

### addListener(string, ...)

```typescript
addListener(eventName: string, listenerFunc: (event: ReadResult) => void) => PluginListenerHandle
```

| Param              | Type                                                                  |
| ------------------ | --------------------------------------------------------------------- |
| **`eventName`**    | <code>string</code>                                                   |
| **`listenerFunc`** | <code>(event: <a href="#readresult">ReadResult</a>) =&gt; void</code> |

**Returns:** <code><a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

---

### addListener('onScanResult', ...)

```typescript
addListener(eventName: 'onScanResult', listenerFunc: (result: ScanResultInternal) => void) => PluginListenerHandle
```

| Param              | Type                                                                                                                   |
| ------------------ | ---------------------------------------------------------------------------------------------------------------------- |
| **`eventName`**    | <code>'onScanResult'</code>                                                                                            |
| **`listenerFunc`** | <code>(result: <a href="#scanresultinternal">ScanResultInternal</a>&lt;<a href="#data">Data</a>&gt;) =&gt; void</code> |

**Returns:** <code><a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

---

### Interfaces

#### InitializeOptions

| Prop                          | Type                 | Description                                                                                                                                                                                                                                                                                                                                      | Default            |
| ----------------------------- | -------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------ |
| **`androidNeverForLocation`** | <code>boolean</code> | If your app doesn't use Bluetooth scan results to derive physical location information, you can strongly assert that your app doesn't derive physical location. (Android only) Requires adding 'neverForLocation' to AndroidManifest.xml https://developer.android.com/guide/topics/connectivity/bluetooth/permissions#assert-never-for-location | <code>false</code> |
| **`withAlert`**               | <code>boolean</code> |                                                                                                                                                                                                                                                                                                                                                  |                    |

#### DisplayStrings

| Prop                   | Type                | Default                          | Since |
| ---------------------- | ------------------- | -------------------------------- | ----- |
| **`scanning`**         | <code>string</code> | <code>"Scanning..."</code>       | 0.0.1 |
| **`cancel`**           | <code>string</code> | <code>"Cancel"</code>            | 0.0.1 |
| **`availableDevices`** | <code>string</code> | <code>"Available devices"</code> | 0.0.1 |
| **`noDeviceFound`**    | <code>string</code> | <code>"No device found"</code>   | 0.0.1 |

#### BleDevice

| Prop           | Type                  | Description                                                                                                                                       |
| -------------- | --------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`deviceId`** | <code>string</code>   | ID of the device, which will be needed for further calls. On **Android** this is the BLE MAC address. On **iOS** and **web** it is an identifier. |
| **`name`**     | <code>string</code>   | Name of the peripheral device.                                                                                                                    |
| **`uuids`**    | <code>string[]</code> |                                                                                                                                                   |

#### RequestBleDeviceOptions

| Prop                   | Type                                          | Description                                                                                                                                                                                                                                               |
| ---------------------- | --------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`services`**         | <code>string[]</code>                         | Filter devices by service UUIDs. UUIDs have to be specified as 128 bit UUID strings, e.g. ['0000180d-0000-1000-8000-00805f9b34fb'] There is a helper function to convert numbers to UUIDs. e.g. [numberToUUID(0x180f)]. (see [UUID format](#uuid-format)) |
| **`name`**             | <code>string</code>                           | Filter devices by name                                                                                                                                                                                                                                    |
| **`namePrefix`**       | <code>string</code>                           | Filter devices by name prefix                                                                                                                                                                                                                             |
| **`optionalServices`** | <code>string[]</code>                         | For **web**, all services that will be used have to be listed under services or optionalServices, e.g. [numberToUUID(0x180f)] (see [UUID format](#uuid-format))                                                                                           |
| **`allowDuplicates`**  | <code>boolean</code>                          | Normally scans will discard the second and subsequent advertisements from a single device. If you need to receive them, set allowDuplicates to true (only applicable in `requestLEScan`). (default: false)                                                |
| **`scanMode`**         | <code><a href="#scanmode">ScanMode</a></code> | Android scan mode (default: <a href="#scanmode">ScanMode.SCAN_MODE_BALANCED</a>)                                                                                                                                                                          |

#### ScanResult

| Prop                   | Type                                                              | Description                                                                                                                                                                                                                                                                                           |
| ---------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`device`**           | <code><a href="#bledevice">BleDevice</a></code>                   | The peripheral device that was found in the scan. **Android** and **web**: `device.name` is always identical to `localName`. **iOS**: `device.name` is identical to `localName` the first time a device is discovered, but after connecting `device.name` is the cached GAP name in subsequent scans. |
| **`localName`**        | <code>string</code>                                               | The name of the peripheral device from the advertisement data.                                                                                                                                                                                                                                        |
| **`rssi`**             | <code>number</code>                                               | Received Signal Strength Indication.                                                                                                                                                                                                                                                                  |
| **`txPower`**          | <code>number</code>                                               | Transmit power in dBm. A value of 127 indicates that it is not available.                                                                                                                                                                                                                             |
| **`manufacturerData`** | <code>{ [key: string]: <a href="#dataview">DataView</a>; }</code> | Manufacturer data, key is a company identifier and value is the data.                                                                                                                                                                                                                                 |
| **`serviceData`**      | <code>{ [key: string]: <a href="#dataview">DataView</a>; }</code> | Service data, key is a service UUID and value is the data.                                                                                                                                                                                                                                            |
| **`uuids`**            | <code>string[]</code>                                             | Advertised services.                                                                                                                                                                                                                                                                                  |
| **`rawAdvertisement`** | <code><a href="#dataview">DataView</a></code>                     | Raw advertisement data (**Android** only).                                                                                                                                                                                                                                                            |

#### DataView

| Prop             | Type                                                |
| ---------------- | --------------------------------------------------- |
| **`buffer`**     | <code><a href="#arraybuffer">ArrayBuffer</a></code> |
| **`byteLength`** | <code>number</code>                                 |
| **`byteOffset`** | <code>number</code>                                 |

| Method         | Signature                                                                           | Description                                                                                                                                                         |
| -------------- | ----------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **getFloat32** | (byteOffset: number, littleEndian?: boolean \| undefined) =&gt; number              | Gets the Float32 value at the specified byte offset from the start of the view. There is no alignment constraint; multi-byte values may be fetched from any offset. |
| **getFloat64** | (byteOffset: number, littleEndian?: boolean \| undefined) =&gt; number              | Gets the Float64 value at the specified byte offset from the start of the view. There is no alignment constraint; multi-byte values may be fetched from any offset. |
| **getInt8**    | (byteOffset: number) =&gt; number                                                   | Gets the Int8 value at the specified byte offset from the start of the view. There is no alignment constraint; multi-byte values may be fetched from any offset.    |
| **getInt16**   | (byteOffset: number, littleEndian?: boolean \| undefined) =&gt; number              | Gets the Int16 value at the specified byte offset from the start of the view. There is no alignment constraint; multi-byte values may be fetched from any offset.   |
| **getInt32**   | (byteOffset: number, littleEndian?: boolean \| undefined) =&gt; number              | Gets the Int32 value at the specified byte offset from the start of the view. There is no alignment constraint; multi-byte values may be fetched from any offset.   |
| **getUint8**   | (byteOffset: number) =&gt; number                                                   | Gets the Uint8 value at the specified byte offset from the start of the view. There is no alignment constraint; multi-byte values may be fetched from any offset.   |
| **getUint16**  | (byteOffset: number, littleEndian?: boolean \| undefined) =&gt; number              | Gets the Uint16 value at the specified byte offset from the start of the view. There is no alignment constraint; multi-byte values may be fetched from any offset.  |
| **getUint32**  | (byteOffset: number, littleEndian?: boolean \| undefined) =&gt; number              | Gets the Uint32 value at the specified byte offset from the start of the view. There is no alignment constraint; multi-byte values may be fetched from any offset.  |
| **setFloat32** | (byteOffset: number, value: number, littleEndian?: boolean \| undefined) =&gt; void | Stores an Float32 value at the specified byte offset from the start of the view.                                                                                    |
| **setFloat64** | (byteOffset: number, value: number, littleEndian?: boolean \| undefined) =&gt; void | Stores an Float64 value at the specified byte offset from the start of the view.                                                                                    |
| **setInt8**    | (byteOffset: number, value: number) =&gt; void                                      | Stores an Int8 value at the specified byte offset from the start of the view.                                                                                       |
| **setInt16**   | (byteOffset: number, value: number, littleEndian?: boolean \| undefined) =&gt; void | Stores an Int16 value at the specified byte offset from the start of the view.                                                                                      |
| **setInt32**   | (byteOffset: number, value: number, littleEndian?: boolean \| undefined) =&gt; void | Stores an Int32 value at the specified byte offset from the start of the view.                                                                                      |
| **setUint8**   | (byteOffset: number, value: number) =&gt; void                                      | Stores an Uint8 value at the specified byte offset from the start of the view.                                                                                      |
| **setUint16**  | (byteOffset: number, value: number, littleEndian?: boolean \| undefined) =&gt; void | Stores an Uint16 value at the specified byte offset from the start of the view.                                                                                     |
| **setUint32**  | (byteOffset: number, value: number, littleEndian?: boolean \| undefined) =&gt; void | Stores an Uint32 value at the specified byte offset from the start of the view.                                                                                     |

#### ArrayBuffer

Represents a raw buffer of binary data, which is used to store data for the
different typed arrays. ArrayBuffers cannot be read from or written to directly,
but can be passed to a typed array or <a href="#dataview">DataView</a> Object to interpret the raw
buffer as needed.

| Prop             | Type                | Description                                                                     |
| ---------------- | ------------------- | ------------------------------------------------------------------------------- |
| **`byteLength`** | <code>number</code> | Read-only. The length of the <a href="#arraybuffer">ArrayBuffer</a> (in bytes). |

| Method    | Signature                                                                               | Description                                                     |
| --------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------- |
| **slice** | (begin: number, end?: number \| undefined) =&gt; <a href="#arraybuffer">ArrayBuffer</a> | Returns a section of an <a href="#arraybuffer">ArrayBuffer</a>. |

#### TimeoutOptions

| Prop          | Type                | Description                                                                                                |
| ------------- | ------------------- | ---------------------------------------------------------------------------------------------------------- |
| **`timeout`** | <code>number</code> | Timeout in milliseconds for plugin call. Default is 10000 for `connect` and 5000 for other plugin methods. |

#### BleService

| Prop                  | Type                             |
| --------------------- | -------------------------------- |
| **`uuid`**            | <code>string</code>              |
| **`characteristics`** | <code>BleCharacteristic[]</code> |

#### BleCharacteristic

| Prop              | Type                                                                                |
| ----------------- | ----------------------------------------------------------------------------------- |
| **`uuid`**        | <code>string</code>                                                                 |
| **`properties`**  | <code><a href="#blecharacteristicproperties">BleCharacteristicProperties</a></code> |
| **`descriptors`** | <code>BleDescriptor[]</code>                                                        |

#### BleCharacteristicProperties

| Prop                             | Type                 |
| -------------------------------- | -------------------- |
| **`broadcast`**                  | <code>boolean</code> |
| **`read`**                       | <code>boolean</code> |
| **`writeWithoutResponse`**       | <code>boolean</code> |
| **`write`**                      | <code>boolean</code> |
| **`notify`**                     | <code>boolean</code> |
| **`indicate`**                   | <code>boolean</code> |
| **`authenticatedSignedWrites`**  | <code>boolean</code> |
| **`reliableWrite`**              | <code>boolean</code> |
| **`writableAuxiliaries`**        | <code>boolean</code> |
| **`extendedProperties`**         | <code>boolean</code> |
| **`notifyEncryptionRequired`**   | <code>boolean</code> |
| **`indicateEncryptionRequired`** | <code>boolean</code> |

#### BleDescriptor

| Prop       | Type                |
| ---------- | ------------------- |
| **`uuid`** | <code>string</code> |

#### PermissionStatus

| Prop           | Type                                                                                                                      |
| -------------- | ------------------------------------------------------------------------------------------------------------------------- |
| **`onchange`** | <code>((this: <a href="#permissionstatus">PermissionStatus</a>, ev: <a href="#event">Event</a>) =&gt; any) \| null</code> |
| **`state`**    | <code><a href="#permissionstate">PermissionState</a></code>                                                               |

| Method                  | Signature                                                                                                                                                                                                                                                       | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| ----------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **addEventListener**    | &lt;K extends "change"&gt;(type: K, listener: (this: <a href="#permissionstatus">PermissionStatus</a>, ev: PermissionStatusEventMap[K]) =&gt; any, options?: boolean \| <a href="#addeventlisteneroptions">AddEventListenerOptions</a> \| undefined) =&gt; void | Appends an event listener for events whose type attribute value is type. The callback argument sets the callback that will be invoked when the event is dispatched. The options argument sets listener-specific options. For compatibility this can be a boolean, in which case the method behaves exactly as if the value was specified as options's capture. When set to true, options's capture prevents callback from being invoked when the event's eventPhase attribute value is BUBBLING_PHASE. When false (or not present), callback will not be invoked when event's eventPhase attribute value is CAPTURING_PHASE. Either way, callback will be invoked if event's eventPhase attribute value is AT_TARGET. When set to true, options's passive indicates that the callback will not cancel the event by invoking preventDefault(). This is used to enable performance optimizations described in § 2.8 Observing event listeners. When set to true, options's once indicates that the callback will only be invoked once after which the event listener will be removed. The event listener is appended to target's event listener list and is not appended if it has the same type, callback, and capture. |
| **addEventListener**    | (type: string, listener: <a href="#eventlisteneroreventlistenerobject">EventListenerOrEventListenerObject</a>, options?: boolean \| <a href="#addeventlisteneroptions">AddEventListenerOptions</a> \| undefined) =&gt; void                                     | Appends an event listener for events whose type attribute value is type. The callback argument sets the callback that will be invoked when the event is dispatched. The options argument sets listener-specific options. For compatibility this can be a boolean, in which case the method behaves exactly as if the value was specified as options's capture. When set to true, options's capture prevents callback from being invoked when the event's eventPhase attribute value is BUBBLING_PHASE. When false (or not present), callback will not be invoked when event's eventPhase attribute value is CAPTURING_PHASE. Either way, callback will be invoked if event's eventPhase attribute value is AT_TARGET. When set to true, options's passive indicates that the callback will not cancel the event by invoking preventDefault(). This is used to enable performance optimizations described in § 2.8 Observing event listeners. When set to true, options's once indicates that the callback will only be invoked once after which the event listener will be removed. The event listener is appended to target's event listener list and is not appended if it has the same type, callback, and capture. |
| **removeEventListener** | &lt;K extends "change"&gt;(type: K, listener: (this: <a href="#permissionstatus">PermissionStatus</a>, ev: PermissionStatusEventMap[K]) =&gt; any, options?: boolean \| <a href="#eventlisteneroptions">EventListenerOptions</a> \| undefined) =&gt; void       | Removes the event listener in target's event listener list with the same type, callback, and options.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| **removeEventListener** | (type: string, listener: <a href="#eventlisteneroreventlistenerobject">EventListenerOrEventListenerObject</a>, options?: boolean \| <a href="#eventlisteneroptions">EventListenerOptions</a> \| undefined) =&gt; void                                           | Removes the event listener in target's event listener list with the same type, callback, and options.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |

#### PermissionStatusEventMap

| Prop           | Type                                    |
| -------------- | --------------------------------------- |
| **`"change"`** | <code><a href="#event">Event</a></code> |

#### Event

An event which takes place in the DOM.

| Prop                   | Type                                                        | Description                                                                                                                                                                                                                                                |
| ---------------------- | ----------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`bubbles`**          | <code>boolean</code>                                        | Returns true or false depending on how event was initialized. True if event goes through its target's ancestors in reverse tree order, and false otherwise.                                                                                                |
| **`cancelBubble`**     | <code>boolean</code>                                        |                                                                                                                                                                                                                                                            |
| **`cancelable`**       | <code>boolean</code>                                        | Returns true or false depending on how event was initialized. Its return value does not always carry meaning, but true can indicate that part of the operation during which event was dispatched, can be canceled by invoking the preventDefault() method. |
| **`composed`**         | <code>boolean</code>                                        | Returns true or false depending on how event was initialized. True if event invokes listeners past a ShadowRoot node that is the root of its target, and false otherwise.                                                                                  |
| **`currentTarget`**    | <code><a href="#eventtarget">EventTarget</a> \| null</code> | Returns the object whose event listener's callback is currently being invoked.                                                                                                                                                                             |
| **`defaultPrevented`** | <code>boolean</code>                                        | Returns true if preventDefault() was invoked successfully to indicate cancelation, and false otherwise.                                                                                                                                                    |
| **`eventPhase`**       | <code>number</code>                                         | Returns the event's phase, which is one of NONE, CAPTURING_PHASE, AT_TARGET, and BUBBLING_PHASE.                                                                                                                                                           |
| **`isTrusted`**        | <code>boolean</code>                                        | Returns true if event was dispatched by the user agent, and false otherwise.                                                                                                                                                                               |
| **`returnValue`**      | <code>boolean</code>                                        |                                                                                                                                                                                                                                                            |
| **`srcElement`**       | <code><a href="#eventtarget">EventTarget</a> \| null</code> |                                                                                                                                                                                                                                                            |
| **`target`**           | <code><a href="#eventtarget">EventTarget</a> \| null</code> | Returns the object to which event is dispatched (its target).                                                                                                                                                                                              |
| **`timeStamp`**        | <code>number</code>                                         | Returns the event's timestamp as the number of milliseconds measured relative to the time origin.                                                                                                                                                          |
| **`type`**             | <code>string</code>                                         | Returns the type of event, e.g. "click", "hashchange", or "submit".                                                                                                                                                                                        |
| **`AT_TARGET`**        | <code>number</code>                                         |                                                                                                                                                                                                                                                            |
| **`BUBBLING_PHASE`**   | <code>number</code>                                         |                                                                                                                                                                                                                                                            |
| **`CAPTURING_PHASE`**  | <code>number</code>                                         |                                                                                                                                                                                                                                                            |
| **`NONE`**             | <code>number</code>                                         |                                                                                                                                                                                                                                                            |

| Method                       | Signature                                                                                    | Description                                                                                                                                                                                                                             |
| ---------------------------- | -------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **composedPath**             | () =&gt; EventTarget[]                                                                       | Returns the invocation target objects of event's path (objects on which listeners will be invoked), except for any nodes in shadow trees of which the shadow root's mode is "closed" that are not reachable from event's currentTarget. |
| **initEvent**                | (type: string, bubbles?: boolean \| undefined, cancelable?: boolean \| undefined) =&gt; void |                                                                                                                                                                                                                                         |
| **preventDefault**           | () =&gt; void                                                                                | If invoked when the cancelable attribute value is true, and while executing a listener for the event with passive set to false, signals to the operation that caused event to be dispatched that it needs to be canceled.               |
| **stopImmediatePropagation** | () =&gt; void                                                                                | Invoking this method prevents event from reaching any registered event listeners after the current one finishes running and, when dispatched in a tree, also prevents event from reaching any other objects.                            |
| **stopPropagation**          | () =&gt; void                                                                                | When dispatched in a tree, invoking this method prevents event from reaching any objects other than the current object.                                                                                                                 |

#### EventTarget

<a href="#eventtarget">EventTarget</a> is a DOM interface implemented by objects that can receive events and may have listeners for them.

| Method                  | Signature                                                                                                                                                                                                                           | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| ----------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **addEventListener**    | (type: string, listener: <a href="#eventlisteneroreventlistenerobject">EventListenerOrEventListenerObject</a> \| null, options?: boolean \| <a href="#addeventlisteneroptions">AddEventListenerOptions</a> \| undefined) =&gt; void | Appends an event listener for events whose type attribute value is type. The callback argument sets the callback that will be invoked when the event is dispatched. The options argument sets listener-specific options. For compatibility this can be a boolean, in which case the method behaves exactly as if the value was specified as options's capture. When set to true, options's capture prevents callback from being invoked when the event's eventPhase attribute value is BUBBLING_PHASE. When false (or not present), callback will not be invoked when event's eventPhase attribute value is CAPTURING_PHASE. Either way, callback will be invoked if event's eventPhase attribute value is AT_TARGET. When set to true, options's passive indicates that the callback will not cancel the event by invoking preventDefault(). This is used to enable performance optimizations described in § 2.8 Observing event listeners. When set to true, options's once indicates that the callback will only be invoked once after which the event listener will be removed. The event listener is appended to target's event listener list and is not appended if it has the same type, callback, and capture. |
| **dispatchEvent**       | (event: <a href="#event">Event</a>) =&gt; boolean                                                                                                                                                                                   | Dispatches a synthetic event event to target and returns true if either event's cancelable attribute value is false or its preventDefault() method was not invoked, and false otherwise.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| **removeEventListener** | (type: string, callback: <a href="#eventlisteneroreventlistenerobject">EventListenerOrEventListenerObject</a> \| null, options?: boolean \| <a href="#eventlisteneroptions">EventListenerOptions</a> \| undefined) =&gt; void       | Removes the event listener in target's event listener list with the same type, callback, and options.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |

#### EventListener

#### EventListenerObject

| Method          | Signature                                    |
| --------------- | -------------------------------------------- |
| **handleEvent** | (evt: <a href="#event">Event</a>) =&gt; void |

#### AddEventListenerOptions

| Prop          | Type                 |
| ------------- | -------------------- |
| **`once`**    | <code>boolean</code> |
| **`passive`** | <code>boolean</code> |

#### EventListenerOptions

| Prop          | Type                 |
| ------------- | -------------------- |
| **`capture`** | <code>boolean</code> |

#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |

#### BooleanResult

| Prop        | Type                 |
| ----------- | -------------------- |
| **`value`** | <code>boolean</code> |

#### IsActiveResult

| Prop           | Type                 |
| -------------- | -------------------- |
| **`isActive`** | <code>boolean</code> |

#### ReadResult

| Prop        | Type                                  | Description                                                |
| ----------- | ------------------------------------- | ---------------------------------------------------------- |
| **`value`** | <code><a href="#data">Data</a></code> | android, ios: string web: <a href="#dataview">DataView</a> |

#### ScanResultInternal

| Prop                   | Type                                            |
| ---------------------- | ----------------------------------------------- |
| **`device`**           | <code><a href="#bledevice">BleDevice</a></code> |
| **`localName`**        | <code>string</code>                             |
| **`rssi`**             | <code>number</code>                             |
| **`txPower`**          | <code>number</code>                             |
| **`manufacturerData`** | <code>{ [key: string]: T; }</code>              |
| **`serviceData`**      | <code>{ [key: string]: T; }</code>              |
| **`uuids`**            | <code>string[]</code>                           |
| **`rawAdvertisement`** | <code>T</code>                                  |

### Type Aliases

#### EventListenerOrEventListenerObject

<code><a href="#eventlistener">EventListener</a> | <a href="#eventlistenerobject">EventListenerObject</a></code>

#### PermissionState

<code>"denied" | "granted" | "prompt"</code>

#### Data

<code><a href="#dataview">DataView</a> | string</code>

### Enums

#### ScanMode

| Members                     | Value          | Description                                                                                                                                                                                                                                                               |
| --------------------------- | -------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`SCAN_MODE_LOW_POWER`**   | <code>0</code> | Perform Bluetooth LE scan in low power mode. This mode is enforced if the scanning application is not in foreground. https://developer.android.com/reference/android/bluetooth/le/ScanSettings#SCAN_MODE_LOW_POWER                                                        |
| **`SCAN_MODE_BALANCED`**    | <code>1</code> | Perform Bluetooth LE scan in balanced power mode. (default) Scan results are returned at a rate that provides a good trade-off between scan frequency and power consumption. https://developer.android.com/reference/android/bluetooth/le/ScanSettings#SCAN_MODE_BALANCED |
| **`SCAN_MODE_LOW_LATENCY`** | <code>2</code> | Scan using highest duty cycle. It's recommended to only use this mode when the application is running in the foreground. https://developer.android.com/reference/android/bluetooth/le/ScanSettings#SCAN_MODE_LOW_LATENCY                                                  |

</docgen-api>

### UUID format

All UUIDs have to be provided in 128 bit format as string, e.g. `'0000180d-0000-1000-8000-00805f9b34fb'`. There is a helper function to convert 16 bit UUID numbers to string:

```typescript
import { numberToUUID } from '@capacitor-community/bluetooth-le';

const HEART_RATE_SERVICE = numberToUUID(0x180d);
// '0000180d-0000-1000-8000-00805f9b34fb'
```

## Troubleshooting

#### Connection fails on Android

On some Android devices `connect()` may fail when the device was connected before, even if the device is not actually connected.
In that case you should first call `disconnect()`, e.g.:

```typesceript
const device = await BleClient.requestDevice({
   // ...
});
// ...
await BleClient.disconnect(device.deviceId);
await BleClient.connect(device.deviceId);
```

## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tbody>
    <tr>
      <td align="center"><a href="https://github.com/pwespi"><img src="https://avatars2.githubusercontent.com/u/24232962?v=4?s=100" width="100px;" alt="pwespi"/><br /><sub><b>pwespi</b></sub></a><br /><a href="https://github.com/capacitor-community/bluetooth-le/commits?author=pwespi" title="Code">💻</a> <a href="https://github.com/capacitor-community/bluetooth-le/commits?author=pwespi" title="Documentation">📖</a></td>
      <td align="center"><a href="https://twitter.com/dennisameling"><img src="https://avatars.githubusercontent.com/u/17739158?v=4?s=100" width="100px;" alt="Dennis Ameling"/><br /><sub><b>Dennis Ameling</b></sub></a><br /><a href="https://github.com/capacitor-community/bluetooth-le/commits?author=dennisameling" title="Code">💻</a></td>
      <td align="center"><a href="http://squio.nl"><img src="https://avatars.githubusercontent.com/u/169410?v=4?s=100" width="100px;" alt="Johannes la Poutre"/><br /><sub><b>Johannes la Poutre</b></sub></a><br /><a href="https://github.com/capacitor-community/bluetooth-le/commits?author=squio" title="Documentation">📖</a> <a href="https://github.com/capacitor-community/bluetooth-le/commits?author=squio" title="Code">💻</a></td>
      <td align="center"><a href="https://github.com/sultanmyrza"><img src="https://avatars.githubusercontent.com/u/12681781?v=4?s=100" width="100px;" alt="Kasymbekov Sultanmyrza"/><br /><sub><b>Kasymbekov Sultanmyrza</b></sub></a><br /><a href="https://github.com/capacitor-community/bluetooth-le/commits?author=sultanmyrza" title="Code">💻</a></td>
      <td align="center"><a href="https://sourcya.com"><img src="https://avatars.githubusercontent.com/u/9040320?v=4?s=100" width="100px;" alt="Mutasim Issa"/><br /><sub><b>Mutasim Issa</b></sub></a><br /><a href="https://github.com/capacitor-community/bluetooth-le/commits?author=mutasimissa" title="Documentation">📖</a></td>
      <td align="center"><a href="http://www.gnucoop.com"><img src="https://avatars.githubusercontent.com/u/1615301?v=4?s=100" width="100px;" alt="Marco Marche"/><br /><sub><b>Marco Marche</b></sub></a><br /><a href="https://github.com/capacitor-community/bluetooth-le/commits?author=trik" title="Code">💻</a></td>
      <td align="center"><a href="https://github.com/JFKakaJFK"><img src="https://avatars.githubusercontent.com/u/13108477?v=4?s=100" width="100px;" alt="Johannes Koch"/><br /><sub><b>Johannes Koch</b></sub></a><br /><a href="https://github.com/capacitor-community/bluetooth-le/commits?author=JFKakaJFK" title="Code">💻</a></td>
    </tr>
    <tr>
      <td align="center"><a href="https://github.com/jrobeson"><img src="https://avatars.githubusercontent.com/u/56908?v=4?s=100" width="100px;" alt="Johnny Robeson"/><br /><sub><b>Johnny Robeson</b></sub></a><br /><a href="https://github.com/capacitor-community/bluetooth-le/commits?author=jrobeson" title="Code">💻</a></td>
    </tr>
  </tbody>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!
