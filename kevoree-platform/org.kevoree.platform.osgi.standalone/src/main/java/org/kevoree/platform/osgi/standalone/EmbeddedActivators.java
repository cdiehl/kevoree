/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.kevoree.platform.osgi.standalone;

import java.util.Arrays;
import java.util.List;
import org.osgi.framework.BundleActivator;

/**
 *
 * @author ffouquet
 */
public class EmbeddedActivators {

    private static List<BundleActivator> activators = Arrays.asList(
                (BundleActivator)new org.ops4j.pax.url.mvn.internal.Activator(),
                (BundleActivator)new org.apache.felix.shell.impl.Activator(),
                (BundleActivator)new org.apache.felix.shell.tui.Activator(),
       //         (BundleActivator)new org.apache.felix.shell.remote.Activator(),
                (BundleActivator)new org.ops4j.pax.url.assembly.internal.Activator(),
                (BundleActivator)new org.kevoree.platform.osgi.standalone.BootstrapActivator()
                );


    public static List<BundleActivator> getActivators(){
        return activators;
    }

    public static void setActivators(List<BundleActivator> newActs){
                 activators = newActs;
    }


}
