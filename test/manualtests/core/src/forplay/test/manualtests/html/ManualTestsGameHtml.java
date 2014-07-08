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
package forplay.test.manualtests.html;

import forplay.html.HtmlAssetManager;

import forplay.core.ForPlay;
import forplay.html.HtmlGame;
import forplay.html.HtmlPlatform;
import forplay.test.manualtests.core.ManualTestsGame;

public class ManualTestsGameHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    HtmlAssetManager assets = platform.assetManager();
    assets.setPathPrefix("manualtestsgame/");
    ForPlay.run(new ManualTestsGame());
    platform.setTitle("Manual Tests");
    HtmlPlatform.disableRightClickContextMenu();
  }
}
