---
title: Ionic Network Alert 
description: Device's network status notification
---

# cordova-plugin-raqmiyat-alert


## Installation
    ionic cordova plugin add cordova-plugin-raqmiyat-alert (or)
    ionic cordova plugin add https://github.com/GMuthuraja/IonicNetworkAlert.git

## Supported Platforms
- Android
- iOS

### How to Use
```
declare var CustomAlert: any; //paste it below the import section

//button onclick function 
checkStatus() { 
CustomAlert.networkCheck((response) => {
      console.log(response);
    }, (error => {
      console.log(error);
})
}
```
