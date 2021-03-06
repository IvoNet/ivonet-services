/*
 * Copyright 2016 Ivo Woltring <WebMaster@ivonet.nl>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.ivonet.service.directory;

import nl.ivonet.service.config.Property;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * Produces {@link Directory}'s.
 *
 * @author Ivo Woltring
 */
public class DirectoryProducer {

    @Inject
    @Property("epub.folder")
    private String epubRootFolder;

    @Inject
    @Property("epub.extensions")
    private String epubExtentions;

    @Inject
    @Property("bliki.folder")
    private String blikiRootFolder;

    @Inject
    @Property("bliki.extensions")
    private String blikiExtentions;

    @Produces
    @EpubDirectory
    public Directory epubDirectoryProducer() {
        return new Directory(this.epubRootFolder, this.epubExtentions);
    }

    @Produces
    @BlikiDirectory
    public Directory blikiDirectoryProducer() {
        return new Directory(this.blikiRootFolder, this.blikiExtentions);
    }


}
