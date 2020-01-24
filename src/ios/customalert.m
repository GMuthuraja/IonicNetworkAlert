/********* CustomAlert.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>
#import "Reachability.h"

@interface CustomAlert : CDVPlugin {
  // Member variables go here.
}

- (void)networkCheck:(CDVInvokedUrlCommand*)command;
@end

@implementation CustomAlert

- (void)networkCheck:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* echo = [command.arguments objectAtIndex:0];

    if ([[Reachability reachabilityForInternetConnection]currentReachabilityStatus]==NotReachable)
    {
        UIAlertController *alert = [UIAlertController alertControllerWithTitle:@"No Network Access"
                                                                       message:@"Please check your network connection!"
                                                                preferredStyle:UIAlertControllerStyleAlert]; // 1
        UIAlertAction *firstAction = [UIAlertAction actionWithTitle:@"OK"
                                                              style:UIAlertActionStyleDefault handler:^(UIAlertAction * action) {
                                                                  NSLog(@"You pressed button one");
                                                              }]; // 2
        
        
        [alert addAction:firstAction]; // 4
        
        
        [self.viewController presentViewController:alert animated:YES completion:nil];
    }
    else
    {
        UIAlertController *alert = [UIAlertController alertControllerWithTitle:@"Network Connected"
                                                                       message:@"You are online now!"
                                                                preferredStyle:UIAlertControllerStyleAlert]; // 1
        UIAlertAction *firstAction = [UIAlertAction actionWithTitle:@"OK"
                                                              style:UIAlertActionStyleDefault handler:^(UIAlertAction * action) {
                                                                  NSLog(@"You pressed button one");
                                                              }]; // 2
        
        [alert addAction:firstAction]; // 4
        
        
        [self.viewController presentViewController:alert animated:YES completion:nil];
    }
    

    if (echo != nil && [echo length] > 0) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:echo];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
