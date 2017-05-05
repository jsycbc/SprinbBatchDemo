package jsycbc.github.com;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../job.xml")
public class JobLauncherTest {

    @Autowired
    private JobLauncher joblauncher;

    @Autowired
    @Qualifier("myjob")
    private Job job;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void test() throws JobExecutionAlreadyRunningException, JobRestartException,
	    JobInstanceAlreadyCompleteException, JobParametersInvalidException {
	assertNotNull("joblauncher should not be null.", joblauncher);
	assertNotNull("job should not be null.", job);
	JobExecution jobExecution = joblauncher.run(job, new JobParameters());
	System.out.println("###### " + jobExecution.toString() + " ######.");
    }

}
