'use strict';

import {
  NativeModules
} from 'react-native';

var RCTLog = NativeModules.Log;

var Log = {
  TAG: RCTLog.TAG,
  d: function(tag:string, msg:string):void {
    console.log(tag, msg);
    RCTLog.d(tag, msg);
  }
};

module.exports = Log;
