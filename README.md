ForPlay
=======

Forplay is a cross-platform Java game development library written in [Java]
that targets browsers (via [Google Web Toolkit]), [Android] devices and
[Flash].

Information on ForPlay can be found in in this README and on the ForPlay
project website: http://code.google.com/p/forplay

ForPlay developers, contributors, and users regularly communicate on the
ForPlay Google Group: http://groups.google.com/group/gwt-forplay

Building
--------

ForPlay requires Java 6 or higher. It can be built using one of [Ant], [Maven],
or [Eclipse].

### Getting the source

The ForPlay source code is available via Github. You will need to install a
[Git] client. Check out the source code as follows:

    git clone git://github.com/forplay/forplay.git

The subsequent build instructions will refer to the directory in which you
checked out the ForPlay source as `forplay`.

### Building with Ant

Build and install the ForPlay jar files into your local Maven repository like
so:

    cd forplay
    ant install

### Building with Maven

Build and install the ForPlay jar files into your local Maven repository like
so:

    cd forplay
    mvn install

### Building with Eclipse

To build ForPlay with Eclipse, you must first install the [Google Plugin for
Eclipse] and install support for [GWT] and [Android] development. Detailed
instructions on performing these installations are available on the [Google
Plugin for Eclipse] website.

Once that is installed, choose _File_ → _Import_ and select _General_ →
_Existing Projects into Workspace_. Then enter the directory into which you
checked out ForPlay as the root directory, and Eclipse will autodetect the
various ForPlay subprojects.

Running Sample Games
--------------------

ForPlay comes with a number of sample games, to demonstrate its capabilities.
These are located in `forplay/sample` and include `forplay/sample/peas`,
`forplay/sample/cute`, and `forplay/sample/noise`.

### Running from the command line

To run the samples from the command line, you must use [Ant]. As ForPlay is a
cross-platform game development library, there are multiple ways to run the
sample games. Presently, you can run them using the JVM backend, and the HTML5
backend as compiled JavaScript, and the HTML5 backend via the GWT development
mode.

The following instructions are for the `cute` sample, but can be applied to the
other samples by simply substituting the appropriate directory for the desired
sample.

To run via the JVM backend, do the following:

    cd forplay/sample/cute/core
    ant run-java

To compile the code into JavaScript and run in a web browser, do the following:

    cd forplay/sample/cute/core
    ant run-html
    # the Ant output will display a URL to be opened in your browser
    # in cute's case it is: http://localhost:8080/cute/CuteGame.html

To run the code via the GWT development mode, do the following:

    cd forplay/sample/cute/core
    ant run-devmode
    # then click 'Launch Default Browser' in the devmode console
    # you may need to install the GWT devmode plugin at this point

Note that testing in GWT devmode is not recommended. Performance is extremely
poor in GWT devmode due to the way JavaScript and Java communicate. Performance
of the compiled JavaScript is substantially better.

### Running from Eclipse

To run the samples from Eclipes, expand the desired sample's subtree in the
_Package Explorer_ and right click on, for example, `cute-java.launch`. Then
select _Run as_ → _cute-java_. This will launch the cute sample game using the
JVM backend.

It is also possible to launch a sample using GWT devmode via the
`game-html.launch` launch file, but running games via GWT devmode is not
recommended due to unavoidable performance problems. Compiling the game to
JavaScript and running directly in a browser is usually better for in-browser
testing.

Using ForPlay
-------------

To use ForPlay in your project, you must currently check out the source and
build and install the ForPlay artifacts into your local Maven repository.
ForPlay will eventually ship stable artifacts to the Maven Central repository,
and snapshot artifacts to the SonaType OSS repository, but that's not set up
yet.

Once you have built and installed ForPlay (per the directions in the _Building_
section above), you can add a dependency on ForPlay to your Maven project build
like so:

    <dependency>
      <groupId>com.googlecode.forplay</groupId>
      <artifactId>core</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>

If you use Ivy or another build system that supports fetching artifacts from
Maven repositories, you can simply translate the above into the syntax used by
your build system.

If you do not use a build system that supports Maven repository dependencies,
you can copy the ForPlay artifacts directly into any location you desire. They
will have been installed in:

    ~/.m2/repository/com/googlecode/forplay/core/1.0-SNAPSHOT/core-1.0-SNAPSHOT.jar
    ~/.m2/repository/com/googlecode/forplay/webgl/1.0-SNAPSHOT/webgl-1.0-SNAPSHOT.jar
    ~/.m2/repository/com/googlecode/forplay/jbox2d/1.0-SNAPSHOT/jbox2d-1.0-SNAPSHOT.jar
    ~/.m2/repository/com/googlecode/forplay/server/1.0-SNAPSHOT/server-1.0-SNAPSHOT.jar

Licensing
---------

Unless otherwise stated, all source files are licensed under the Apache License, Version 2.0:

    Copyright 2011 The ForPlay Authors

    Licensed under the Apache License, Version 2.0 (the "License"); you may not
    use this file except in compliance with the License. You may obtain a copy
    of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
    License for the specific language governing permissions and limitations
    under the License.

Additional license info:

* Code under: core/gwtbox2d
  URL: http://www.jbox2d.org/
  License: zlib
  Description: GWT-friendly adaptation of JBox2D.
  Local Modifications: Various modifications to support cross-compilation to
  supported platforms.

* Image resources under: sample/[cute peas]
  URL: http://www.lostgarden.com/2007/03/lost-garden-license.html
  License: Creative Commons (CC BY 3.0) - http://creativecommons.org/licenses/by/3.0/us/
  Description: Game art resources created by Dan Cook.

* Audio resources under: sample/noise
  URL: http://www.freesound.org/
  License: Creative Commons (various) - http://creativecommons.org/
  Description: Sample audio resources from the Freesound project.

[Java]: http://www.java.com/
[Google Web Toolkit]: http://code.google.com/webtoolkit/
[GWT]: http://code.google.com/webtoolkit/
[Android]: http://www.android.com/
[Flash]: http://www.adobe.com/products/flash.html
[Ant]: http://ant.apache.org/
[Maven]: http://maven.apache.org/
[Eclipse]: http://www.eclipse.org/
[Git]: http://git-scm.com/
[Google Plugin for Eclipse]: http://code.google.com/eclipse/
