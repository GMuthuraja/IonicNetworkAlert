---
title: Ionic Network Alert 
description: Device's network status notification
---

# cordova-plugin-raqmiyat-alert


## Installation
    cordova plugin add cordova-plugin-raqmiyat-alert (or)
    cordova plugin add https://github.com/GMuthuraja/IonicNetworkAlert.git

## Supported Platforms
- Android

### How to Use
```
declare var CustomAlert: any; //paste it below the import section

//onclick function of button 
checkStatus() { 
CustomAlert.networkCheck((response) => {
      console.log(response);
    }, (error => {
      console.log(error);
})
}
```
