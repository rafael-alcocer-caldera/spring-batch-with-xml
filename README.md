## Synopsis

The project is a Spring Boot Application that uses Spring Batch with an XML configuration file.

It uses MySQL as a repository.

The way to process a Step is Chunk Oriented Processing.

Refers to reading the data one at a time, and creating 'chunks' that will be
written out, within a transaction boundary.

One item is read in from an ItemReader, handed to an ItemProcessor, and
aggregated to a List.

Once the number of items read equals the commit interval, the entire chunk is
written out via the ItemWriter, and then the transaction is committed.

This commit interval is equals to the chunk size.
This is configurable through the batchJob.xml file within the attribute commit-interval. 

## Motivation

I wanted to have an easy example about Spring Batch using Chunk Oriented Processing with an XML configuration file.

## Tests

In Eclipse use: Run As -> Spring Boot App

Then open a browser with the following URL: http://localhost:8080/executeJob

After clicking Enter if the Job is executed correctly you will see a response like this: Job Executed!! 1501012703389

## Output Log Example

2017-07-25 14:58:23.287  INFO 17176 --- [nio-8080-exec-1] o.s.b.c.l.support.SimpleJobLauncher      : Job: [FlowJob: [name=job]] launched with the following parameters: [{time=1501012703201}]
2017-07-25 14:58:23.322  INFO 17176 --- [nio-8080-exec-1] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step1]

2017-07-25 14:58:23.340  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: a, count: 1

2017-07-25 14:58:23.340  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: b, count: 2

2017-07-25 14:58:23.341  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: a

2017-07-25 14:58:23.341  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: A

2017-07-25 14:58:23.341  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: b

2017-07-25 14:58:23.342  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: B

2017-07-25 14:58:23.342  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...START

2017-07-25 14:58:23.342  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: A

2017-07-25 14:58:23.342  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: B

2017-07-25 14:58:23.342  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END

2017-07-25 14:58:23.348  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: c, count: 3

2017-07-25 14:58:23.348  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: d, count: 4

2017-07-25 14:58:23.348  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: c

2017-07-25 14:58:23.348  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: C

2017-07-25 14:58:23.348  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: d

2017-07-25 14:58:23.348  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: D

2017-07-25 14:58:23.348  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...START

2017-07-25 14:58:23.348  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: C

2017-07-25 14:58:23.348  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: D

2017-07-25 14:58:23.348  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END

2017-07-25 14:58:23.353  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: e, count: 5

2017-07-25 14:58:23.353  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: f, count: 6

2017-07-25 14:58:23.353  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: e

2017-07-25 14:58:23.353  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: E

2017-07-25 14:58:23.353  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: f

2017-07-25 14:58:23.353  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: F

2017-07-25 14:58:23.353  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...START

2017-07-25 14:58:23.353  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: E

2017-07-25 14:58:23.353  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: F

2017-07-25 14:58:23.353  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END

2017-07-25 14:58:23.358  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: g, count: 7

2017-07-25 14:58:23.358  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: h, count: 8

2017-07-25 14:58:23.359  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: g

2017-07-25 14:58:23.359  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: G

2017-07-25 14:58:23.359  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: h

2017-07-25 14:58:23.359  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: H

2017-07-25 14:58:23.359  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...START

2017-07-25 14:58:23.359  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: G

2017-07-25 14:58:23.359  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: H

2017-07-25 14:58:23.359  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END

2017-07-25 14:58:23.363  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: i, count: 9

2017-07-25 14:58:23.363  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: j, count: 10

2017-07-25 14:58:23.364  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: i

2017-07-25 14:58:23.364  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: I

2017-07-25 14:58:23.364  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: j

2017-07-25 14:58:23.364  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: J

2017-07-25 14:58:23.364  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...START

2017-07-25 14:58:23.364  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: I

2017-07-25 14:58:23.364  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: J

2017-07-25 14:58:23.364  INFO 17176 --- [nio-8080-exec-1] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END

2017-07-25 14:58:23.388  INFO 17176 --- [nio-8080-exec-1] o.s.b.c.l.support.SimpleJobLauncher      : Job: [FlowJob: [name=job]] completed with the following parameters: [{time=1501012703201}] and the following status: [COMPLETED]

## License

All work is under Apache 2.0 license