/**
 * Copyright 2011 The ForPlay Authors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package forplay.test.manualtests.core;

import forplay.core.Color;

import forplay.core.ResourceCallback;

import forplay.core.CanvasLayer;
import forplay.core.ForPlay;
import forplay.core.GroupLayer;
import forplay.core.Image;
import forplay.core.ImageLayer;
import forplay.core.SurfaceLayer;

public class ImageTypeTest extends ManualTest {
  GroupLayer rootLayer;

  static float width = 100;
  static float height = 100;
  static String imageSrc = "images/imagetypetest.png";

  Image image1;
  ImageLayer imageLayer1;
  SurfaceLayer surfaceLayer1;
  CanvasLayer canvasLayer1;
  ImageLayer imageLayer2;
  SurfaceLayer surfaceLayer2;
  CanvasLayer canvasLayer2;

  @Override
  public String getName() {
    return "ImageTypeTest";
  }

  @Override
  public String getDescription() {
    return "Test that image types display the same. Left-to-right: ImageLayer, SurfaceLayer, CanvasLayer";
  }

  @Override
  public void init() {
    rootLayer = ForPlay.graphics().rootLayer();
    // add a half white, half blue background
    SurfaceLayer bg = ForPlay.graphics().createSurfaceLayer((int) (3 * width), (int) (3 * height));
    bg.surface().setFillColor(Color.rgb(255, 255, 255));
    bg.surface().fillRect(0, 0, bg.surface().width(), bg.surface().height());
    bg.surface().setFillColor(Color.rgb(0, 0, 255));
    bg.surface().fillRect(0, bg.surface().width() / 2, bg.surface().width(),
        bg.surface().height() / 2);
    rootLayer.add(bg);

    image1 = ForPlay.assetManager().getImage(imageSrc);
    image1.addCallback(new ResourceCallback<Image>() {
      @Override
      public void done(Image image) {
        // once the image loads, create our layers
        imageLayer1 = ForPlay.graphics().createImageLayer(image);
        surfaceLayer1 = ForPlay.graphics().createSurfaceLayer(image.width(), image.height());
        surfaceLayer1.surface().drawImage(image, 0, 0);
        canvasLayer1 = ForPlay.graphics().createCanvasLayer(image.width(), image.height());
        canvasLayer1.canvas().drawImage(image, 0, 0);
        imageLayer2 = ForPlay.graphics().createImageLayer(image);
        surfaceLayer2 = ForPlay.graphics().createSurfaceLayer(image.width(), image.height());
        surfaceLayer2.surface().drawImage(image, 0, 0);
        canvasLayer2 = ForPlay.graphics().createCanvasLayer(image.width(), image.height());
        canvasLayer2.canvas().drawImage(image, 0, 0);

        // add layers to the rootLayer
        int offset = 5;
        imageLayer1.transform().translate(offset, offset);
        rootLayer.add(imageLayer1);
        surfaceLayer1.transform().translate(offset + width, offset);
        rootLayer.add(surfaceLayer1);
        canvasLayer1.transform().translate(offset + 2 * width, offset);
        rootLayer.add(canvasLayer1);

        imageLayer2.transform().translate(offset, offset + 2 * height);
        rootLayer.add(imageLayer2);
        surfaceLayer2.transform().translate(offset + width, offset + 2 * height);
        rootLayer.add(surfaceLayer2);
        canvasLayer2.transform().translate(offset + 2 * width, offset + 2 * height);
        rootLayer.add(canvasLayer2);
      }

      @Override
      public void error(Throwable err) {
        ForPlay.log().error("Error loading image", err);
      }
    });
  }
}
