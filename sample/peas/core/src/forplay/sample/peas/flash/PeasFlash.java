/**
 * Copyright 2010 The ForPlay Authors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package forplay.sample.peas.flash;

import forplay.flash.FlashAssetManager;

import forplay.core.ForPlay;
import forplay.flash.FlashGame;
import forplay.flash.FlashPlatform;
import forplay.sample.peas.core.Peas;

public class PeasFlash extends FlashGame {

  @Override
  public void start() {
    FlashAssetManager assets = FlashPlatform.register().assetManager();
    assets.setPathPrefix("peas/");
    ForPlay.run(new Peas());
  }
}
