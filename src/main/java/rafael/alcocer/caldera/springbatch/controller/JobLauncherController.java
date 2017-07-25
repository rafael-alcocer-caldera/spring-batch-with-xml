/**
 * Copyright [2017] [RAFAEL ALCOCER CALDERA]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rafael.alcocer.caldera.springbatch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * To execute the Job you just need to open a browser and put the URL:
 * 
 * http://localhost:8080/executeJob
 * 
 * If the Job is executed correctly you will see a response like this:
 * 
 * Job Executed!!
 * 
 * @author Rafael Alcocer Caldera
 * @version 1.0
 *
 */
@RestController
public class JobLauncherController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @RequestMapping("/executeJob")
    public String handle() throws Exception {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	try {
	    JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
		    .toJobParameters();
	    jobLauncher.run(job, jobParameters);
	} catch (Exception e) {
	    logger.info(e.getMessage());
	}

	return "Job Executed!! " + System.currentTimeMillis();
    }
}