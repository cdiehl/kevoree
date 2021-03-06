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

package org.kevoree.adaptation.deploy.osgi.command

import org.kevoree.ContainerRoot
import org.kevoree.DeployUnit
import scala.collection.JavaConversions._

object CommandHelper {

  def buildKEY(du : DeployUnit) : String = {
    du.getName+"/"+buildQuery(du,None)
  }

  def buildAllQuery(du : DeployUnit) : List[String] = {
    var res : List[String] = List()
    var root = du.eContainer.asInstanceOf[ContainerRoot]
    root.getRepositories.foreach{repo=>
      if(repo.getUnits.exists(p=>p == du)){
        res = res ++ List(buildQuery(du,Some(repo.getUrl)))
      }
    }
    res match {
      case List()=> println("Add default location"); res = res ++ List(buildQuery(du,None))
      case _ =>
    }
    res
  }

  def buildQuery(du : DeployUnit,repoUrl:Option[String]) : String = {
    var query = new StringBuilder
    query.append("mvn:")
    repoUrl match {
      case Some(r)=> query.append(r);query.append("!")
      case None =>
    }
    query.append(du.getGroupName)
    query.append("/")
    query.append(du.getUnitName)
    du.getVersion match {
      case "default"=>
      case ""=>
      case _ => query.append("/");query.append(du.getVersion)
    }
    query.toString
  }

}
