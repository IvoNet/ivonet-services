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

import nl.ivonet.helper.WeldJUnit4Runner;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Ivo Woltring
 */
@RunWith(WeldJUnit4Runner.class)
public class DirectoryTest {

    @Inject
    @EpubDirectory
    private Directory directory;


    @Test
    public void testRootFolder() throws Exception {
        final Folder folder = this.directory.folder();
        assertThat(folder.getFolders()
                         .size(), Is.is(2));
        assertThat(folder.getPath(), Is.is(""));
        assertThat(folder.getFiles()
                         .size(), Is.is(0));
    }

    @Test
    public void testFolderBramStoker() throws Exception {
        final Folder folder = this.directory.folder("Stoker, Bram");
        assertThat(folder.getFolders()
                         .size(), Is.is(0));
        assertThat(folder.getPath(), Is.is("Stoker, Bram"));
        assertThat(folder.getFiles()
                         .size(), Is.is(1));
        assertThat(folder.getFiles()
                         .get(0), Is.is("pg345.epub"));
    }
}