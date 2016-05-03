package com.marklogic.spring.batch.core;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Entity;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;

@XmlRootElement(name = "stepExecution", namespace=MarkLogicSpringBatch.STEP_EXECUTION_NAMESPACE)
@XmlType(namespace=MarkLogicSpringBatch.STEP_EXECUTION_NAMESPACE)
public class AdaptedStepExecution extends Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JobExecution jobExecution;
	private Long jobExecutionId;
	private String stepName;
	private BatchStatus status = BatchStatus.STARTING;
	private int readCount = 0;
	private int writeCount = 0;
	private int commitCount = 0;
	private int rollbackCount = 0;
	private int readSkipCount = 0;
	private int processSkipCount = 0;
	private int writeSkipCount = 0;
	private Date startTime = null;
	private Date endTime = null;
	private Date lastUpdated = null;
	//private ExecutionContext executionContext = new ExecutionContext();
	private String exitStatus = ExitStatus.EXECUTING.toString();
	private boolean terminateOnly;
	private int filterCount;
	private List<Throwable> failureExceptions = new CopyOnWriteArrayList<Throwable>();
	
	public AdaptedStepExecution() { 
		
	}
	
	public AdaptedStepExecution(StepExecution stepExec) {
		this.setId(stepExec.getId());
		this.setStepName(stepExec.getStepName());
		this.setStatus(stepExec.getStatus());
		this.setReadSkipCount(stepExec.getReadSkipCount());
		this.setWriteSkipCount(stepExec.getWriteSkipCount());
		this.setProcessSkipCount(stepExec.getProcessSkipCount());
		this.setRollbackCount(stepExec.getRollbackCount());
		//this.jobExecution = stepExec.getJobExecution();
		this.setJobExecutionId(stepExec.getJobExecutionId());
		this.setReadCount(stepExec.getReadCount());
		this.setWriteCount(stepExec.getWriteCount());
		this.setFilterCount(stepExec.getFilterCount());
		this.startTime = stepExec.getStartTime();
		this.lastUpdated = stepExec.getLastUpdated();		
	}
	
	public JobExecution getJobExecution() {
		//return jobExecution;
		return null;
	}

	public void setJobExecution(JobExecution jobExecution) {
		//this.jobExecution = jobExecution;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public BatchStatus getStatus() {
		return status;
	}

	public void setStatus(BatchStatus status) {
		this.status = status;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getWriteCount() {
		return writeCount;
	}

	public void setWriteCount(int writeCount) {
		this.writeCount = writeCount;
	}

	public int getCommitCount() {
		return commitCount;
	}

	public void setCommitCount(int commitCount) {
		this.commitCount = commitCount;
	}

	public int getRollbackCount() {
		return rollbackCount;
	}

	public void setRollbackCount(int rollbackCount) {
		this.rollbackCount = rollbackCount;
	}

	public int getReadSkipCount() {
		return readSkipCount;
	}

	public void setReadSkipCount(int readSkipCount) {
		this.readSkipCount = readSkipCount;
	}

	public int getProcessSkipCount() {
		return processSkipCount;
	}

	public void setProcessSkipCount(int processSkipCount) {
		this.processSkipCount = processSkipCount;
	}

	public int getWriteSkipCount() {
		return writeSkipCount;
	}

	public void setWriteSkipCount(int writeSkipCount) {
		this.writeSkipCount = writeSkipCount;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getExitStatus() {
		return exitStatus;
	}

	public void setExitStatus(ExitStatus exitStatus) {
		this.exitStatus = exitStatus.toString();
	}

	public boolean isTerminateOnly() {
		return terminateOnly;
	}

	public void setTerminateOnly(boolean terminateOnly) {
		this.terminateOnly = terminateOnly;
	}

	public int getFilterCount() {
		return filterCount;
	}

	public void setFilterCount(int filterCount) {
		this.filterCount = filterCount;
	}

	public List<Throwable> getFailureExceptions() {
		return failureExceptions;
	}

	public void setFailureExceptions(List<Throwable> failureExceptions) {
		this.failureExceptions = failureExceptions;
	}

	public Long getJobExecutionId() {
		return jobExecutionId;
	}

	public void setJobExecutionId(Long jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
	}    
    	
}
