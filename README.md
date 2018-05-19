## Synopsis

The project is a Spring Boot Application that uses Spring Batch with an XML configuration file.

It uses HSQLDB as a repository.

The way to process a Step is Chunk Oriented Processing.

Refers to reading the data one at a time, and creating 'chunks' that will be
written out, within a transaction boundary.

One item is read in from an ItemReader, handed to an ItemProcessor, and
aggregated to a List.

Once the number of items read equals the commit interval, the entire chunk is
written out via the ItemWriter, and then the transaction is committed.

This commit interval is equals to the chunk size.
This is configurable through the batchJob.xml file within the attribute commit-interval. 

This application only reads a String array of lowercase letters ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j").

Process the letters to uppercase.

Writes the letters in chunks of 2.

## Motivation

I wanted to have an easy example about Spring Batch using Chunk Oriented Processing with an XML configuration file.

## Tests

In Eclipse use: Run As -> Spring Boot App

Then open a browser with the following URL: http://localhost:8080/executeJob

After clicking Enter if the Job is executed correctly you will see a response like this: Job Executed!! 1501012703389

## Output Log Example

2018-05-19 14:16:00.283  INFO 2288 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [FlowJob: [name=job]] launched with the following parameters: [{}]

2018-05-19 14:16:00.741  INFO 2288 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step1]

2018-05-19 14:16:00.959  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: a, count: 1

2018-05-19 14:16:00.959  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: b, count: 2

2018-05-19 14:16:00.973  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: a

2018-05-19 14:16:00.978  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: A

2018-05-19 14:16:00.978  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: b

2018-05-19 14:16:00.979  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: B

2018-05-19 14:16:00.990  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...START

2018-05-19 14:16:00.990  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: A

2018-05-19 14:16:00.990  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: B

2018-05-19 14:16:00.991  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END

2018-05-19 14:16:01.010  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: c, count: 3

2018-05-19 14:16:01.016  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: d, count: 4

2018-05-19 14:16:01.017  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: c

2018-05-19 14:16:01.017  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: C

2018-05-19 14:16:01.017  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: d

2018-05-19 14:16:01.017  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: D

2018-05-19 14:16:01.018  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...START

2018-05-19 14:16:01.026  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: C

2018-05-19 14:16:01.026  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: D

2018-05-19 14:16:01.026  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END

2018-05-19 14:16:01.052  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: e, count: 5

2018-05-19 14:16:01.058  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: f, count: 6

2018-05-19 14:16:01.058  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: e

2018-05-19 14:16:01.071  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: E

2018-05-19 14:16:01.071  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: f

2018-05-19 14:16:01.072  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: F

2018-05-19 14:16:01.072  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...START

2018-05-19 14:16:01.072  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: E

2018-05-19 14:16:01.072  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: F

2018-05-19 14:16:01.072  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END

2018-05-19 14:16:01.105  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: g, count: 7

2018-05-19 14:16:01.105  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: h, count: 8

2018-05-19 14:16:01.105  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: g

2018-05-19 14:16:01.106  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: G

2018-05-19 14:16:01.106  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: h

2018-05-19 14:16:01.106  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: H

2018-05-19 14:16:01.112  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...START

2018-05-19 14:16:01.112  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: G

2018-05-19 14:16:01.112  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: H

2018-05-19 14:16:01.112  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END

2018-05-19 14:16:01.166  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: i, count: 9

2018-05-19 14:16:01.168  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: j, count: 10

2018-05-19 14:16:01.190  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: i

2018-05-19 14:16:01.199  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: I

2018-05-19 14:16:01.201  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: j

2018-05-19 14:16:01.210  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: J

2018-05-19 14:16:01.210  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...START

2018-05-19 14:16:01.220  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: I

2018-05-19 14:16:01.220  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: J

2018-05-19 14:16:01.221  INFO 2288 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END

2018-05-19 14:16:01.328  INFO 2288 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [FlowJob: [name=job]] completed with the following parameters: [{}] and the following status: [COMPLETED]

## Notes

If you Download ZIP, you'll get the file: "spring-batch-with-xml-master.zip".
If you have 7-Zip, choose extract here and you'll get the folder: "spring-batch-with-xml-master".

Within Eclipse you can choose Import... -> General -> Existing Projects into Workspace
Select root directory and browse the directory where you extracted the zip file.
Select "Copy projects into workspace".
You'll have the project imported with a lot of errors. Don't worry.
Go to menu and select Project -> Clean...
After select the project and clic to right button of the mouse to see the menu and select Maven -> Update Project...
Don't forget to have selected:
- Force Update of Snapshots/Releases
- Update project configuration from pom.xml
- Refresh workspace resources from local filesystem
- Clean projects
And clic OK.

Or

Within Eclipse you can choose Import... -> Maven -> Existing Maven Projects 
Root directory and browse.
If you have your folder in a different location of your workspace and
Select "Add project(s) to working set" -> spring-batch-with-xml (this will be the name of your project).
But if your folder is in your workspace the name will be: spring-batch-with-xml-master
This is cleaner that the other. No need to do other things.
But remember that you are not copying this folder into your workspace.

## License

All work is under Apache 2.0 license
