from invoke import task,run

@task
def foo():
    print "ujjwal"
    run('ls', echo=True)
    run("find . -iname '*.pyc' -delete", echo=True)


foo()
