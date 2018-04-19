#!/bin/bash 

#-----------------------------------------------------------------------------------------------------------------------------------------------
# personal configuration
#-----------------------------------------------------------------------------------------------------------------------------------------------
export LS_COLORS="no=00:fi=00:di=00;34:ln=00;36:pi=40;33:so=00;35:bd=40;33;01:cd=40;33;01:or=01;05;37;41:mi=01;05;37;41:ex=00;35:*.cmd=00;32:*.exe=00;32:*.sh=00;32:*.gz=00;31:*.bz2=00;31:*.bz=00;31:*.tz=00;31:*.rpm=00;31:*.cpio=00;31:*.t=93:*.pm=00;36:*.pod=00;96:*.conf=00;33:*.off=00;9:*.jpg=00;94:*.png=00;94:*.xcf=00;94:*.JPG=00;94:*.gif=00;94:*.pdf=00;91"

#-----------------------------------------------------------------------------------------------------------------------------------------------
# VIM http://vim.wikia.com/wiki/
#-----------------------------------------------------------------------------------------------------------------------------------------------
# go to line
42G
42gg
:42<CR>

# move page up/down
H   move to top of screen
M   move to middle of screen
L   move to bottom of screen
Ctrl-D  move half-page down
Ctrl-U  move half-page up
Ctrl-B  page up
Ctrl-F  page down

# copy paste
# Press v to select characters, or uppercase V to select whole lines, or Ctrl-v to select rectangular blocks
# Press d to cut (or y to copy).
# Press P to paste before the cursor, or p to paste after.

# delete
# d $ (note, that's a dollar sign, not an 'S') will delete from the current cursor position to the end of the current line

# search and replace
:%s/foo/bar/g

#-----------------------------------------------------------------------------------------------------------------------------------------------
# bash http://wiki.bash-hackers.org/start
#-----------------------------------------------------------------------------------------------------------------------------------------------

# bash exit status http://tldp.org/LDP/abs/html/exit-status.html
# *****************************************************************************
# $?-The exit status of the last command executed.
# $0-The filename of the current script.
# $#-The number of arguments supplied to a script.
# $$-The process number of the current shell. For shell scripts, this is the process ID under which they are executing

# command: test http://wiki.bash-hackers.org/commands/classictest
# *****************************************************************************


#-----------------------------------------------------------------------------------------------------------------------------------------------
# ---------  NETWORK --------------
#-----------------------------------------------------------------------------------------------------------------------------------------------
# network tools
netstat -ln | grep 127.0.0.*:2500

# cntlm proxy on passent4
nohup ./cntlm -c cntlm.ini &

# show server name
uname -n

# copy files between servers scp
scp username@b:/path/to/file /path/to/destination
#example:
scp tk3sy@passint2:/app/pass/e_qipa_load1_batch/output/PAYMENTS_SEPA/received/*.CT /cygdrive/c/TEMP/
# secure  copy from server to local windows machine
scp tk3sy@passent5:/app/pass/e_pass_inttest_trunk_batch/output/NOTICE_DOC1/received/100002.0000.MPD1.PA000012.DET /cygdrive/c/TEMP/
scp tk3sy@passent5:/app/pass/e_ipass_inttest_trunk_batch/output/NOTICE_DOC1/received/100022.0000.MPD1.IP105335.DET /cygdrive/c/local/projects/passIII/
# secure copy from local windows machine to server
scp /cygdrive/c/TEMP/ tk3sy@passent5:/app/pass/e_pass_inttest_trunk_batch/output/NOTICE_DOC1/received/100002.0000.MPD1.PA000012.DET

# secure copy from home directory
scp tk3sy@passent5:/home/tk3sy/failed_messages.log* .

# secure copy generated files from load environment to local
scp tk3sy@passint2:/app/pass/e_qipa_load1_batch/output/NOTICE_POWERCENTER/received/100200.0000.RDT1.IP022548.RRUEHT .

# secure copy generated files from prod ipass environment to int aka load user home
scp tk3sy@passprod2:/app/ipass/e_ipass_prod_batch/output/NOTICE_POWERCENTER/valid/100200.0000.RDT1.IP022547.RRUEHT.bz2 .

#-----------------------------------------------------------------------------------------------------------------------------------------------
# ---------  FIND AND SEARCH IN FILES, ETC. --------------
#-----------------------------------------------------------------------------------------------------------------------------------------------
# find commands
# does some sort of couting ...
find . -type f | xargs grep -c check $1 | grep -v ":0"

find . -type f -name '*.ext' | xargs grep -Hn 'find-text'

# grep -l = list files with match
find /path/to -name "*.html" -exec grep -l "rumpus" '{}' +
find . -name "*.xml" -exec grep -l "plugitron" '{}' +

# find where file names have spaces in them
find env-tools/jobs -name *.xml -print0 | xargs -0 grep -Hn -e '<url>passent3' -e '<connection>scm' '{}' +

# regular expression grep
find ./shared -type f   | xargs grep -Hn -e '.*postalcode.*'

# (find all the files modified less than 1 day)
find . -mtime -1 

# search through bz2 files
find -type f -name '*.bz2' -execdir bzgrep "pattern" {} \;

# find files and list timestamp details
find . -name shared-processing*.jar -printf '%Tc %p\n'

# find expression in files and list unique files once
grep 'text-to-find' *.txt | grep -v filter | uniq
# grep n digit pattern
grep -E '<refNo>[0-9]{<N-digit-lenght>}' <filename>

# find/grep multiple strings
egrep -n "str1|str2|str3" file_names

# find and delete files
find . -name "*.iml" -type f -delete

# find certain files and archive / package
find ./home/jobs/QA*-BACKUP* -type f -name "config.xml" | xargs tar zcvf passqa3-qamaint-backupjobs.tar.gz

# find files with create date in last 24 hrs (mtime 1 day) of type file and name pattern and list with ls format except those with with extension IDX
# -mtime n => File's data was last modified n*24 hours ago.  
find . -maxdepth 1 -mtime -1 -type f -name '100200.0000.*'  -not -name "*.IDX" -ls 
# OR
find . -maxdepth 1 -type f -name '100200.0000.*'  -not -name "*.IDX"
# and
find . -maxdepth 1 -type f -name '100*'  -not -name "*.IDX" |  xargs grep -Hn -e 'layout' | uniq -d
# move files created 2 days ago
find ./ -type f -maxdepth 1 -mtime 3 -exec mv {} 20170124 \;

# find in multiple file name patterns and excluding directory-name
find . -type f \( -name "*.xml" -o -name "*.java" -o -name "*.properties" \) -not -path "./*/target/*" | xargs grep -Hn '73.0'

# find in multiple zip files. The difference between ; and + is that with ; a single grep command for each file is executed 
# whereas with + as many files as possible are given as parameters to grep at once
find . -name *.ZIP -exec zipgrep '532206' {} \;

#----------------------------------------------------------------------------------------------------------------------
# ---------  TEXT MANIPULATION
#----------------------------------------------------------------------------------------------------------------------
sed -i 's/73.0.0-SNAPSHOT/74.0.0-SNAPSHOT/g' *.xml
find . -type f -exec sed -i 's/foo/bar/g' {} +
find . -type f -name pom.xml -exec sed -i 's/scm:svn.*8080.*\/trunk/scm:git:${git.repo.url}/g' {} +


#-----------------------------------------------------------------------------------------------------------------------------------------------
# archive and compressed files utils  
#-----------------------------------------------------------------------------------------------------------------------------------------------
# look for text in tarballs
zgrep -a 310666  NOTICE_ARCHIVE/received/*.GZ

# look at contents of a jar file including details (v)
jar tvf file.jar


#-----------------------------------------------------------------------------------------------------------------------------------------------
#   compare load with prod on  
#-----------------------------------------------------------------------------------------------------------------------------------------------
# make directories for load and prod a given processing to copy the files to be compared
mkdir 20170116-load 20170116-prod
# find desired notice files in LOAD excluding index files ...
#find . -maxdepth 1 -mtime -1 -type f -name '100200.0000.*' -not -name "*.IDX" (-ls)
# OR using processing date
# pass@passint2:/app/pass/e_qipa_load1_batch/output/NOTICE_POWERCENTER/received/ [TIPA01S1] grep processingDate * | grep 2017-01-15 | grep 100200
grep processingDate * | grep 2017-01-16 | grep 100200
# and copy generated files from load environment to load user home (excute in user home)
cd /home/tk3sy/LOADDIFF/20170116/load/ 
cp /app/pass/e_qipa_load1_batch/output/NOTICE_POWERCENTER/received/<list result> .
# log in to respective prod PASSIII instance (iPASS or PASS) and find corresponding files for load (this example notices)
# tk3sy@mpzhlpass13:/app/ipass/e_ipass_prod_batch/output/NOTICE_POWERCENTER/valid/ [] ls -Sltr --ignore '*.IDX.*' | grep 100200 | grep 2017-01-16
ls -Sltr --ignore '*.IDX.*' | grep 100200 | grep 2017-01-15
# secure copy generated files from prod for the same processing day as for load for ipass environment to int aka load user home
cd /home/tk3sy/LOADDIFF/20170116/prod/ 
scp tk3sy@passprod2:/app/ipass/e_ipass_prod_batch/output/NOTICE_POWERCENTER/valid/<list result> .
# uncompress bz2 files
bzip2 -d *.bz2
# list files for easy compare (remove part in name that makes sorting difficult)
# ls -l | sed 's/\.IP.*\././g' | sort -V
# compare file sizes
#diff -y file1 file2
#tk3sy@passint2:/home/tk3sy/LOADDIFF/20170116/ [] ll -Rh
cd ../
ll -Rh
ll -h load/100200.0000.RDT1.IP022560.RRUEHT prod/100200.0000.RDT1.IP022560.RRUEHT
#tk3sy@passint2:/home/tk3sy/LOADDIFF/20170116/ [] ll -h load/100200.0000.RDT1.IP022560.RRUEHT prod/100200.0000.RDT1.IP022560.RRUEHT
#-rw-r----- 1 tk3sy g-tk3sy 2.5G 2017-01-19 17:03 load/100200.0000.RDT1.IP022560.RRUEHT
#-rw-r----- 1 tk3sy g-tk3sy  61M 2017-01-19 17:23 prod/100200.0000.RDT1.IP022560.RRUEHT


#-----------------------------------------------------------------------------------------------------------------------------------------------
# ---------  PASS SCRIPTS / UTILITIES --------------
#-----------------------------------------------------------------------------------------------------------------------------------------------
# deploy PASS on any server that has the deploy script
deployOnlineJBoss.sh -v 68.0.0-SNAPSHOT -u INTTEST_IPASS_TRUNK -p INTTEST_IPASS_TRUNK -n DPAS20 -r

#-----------------------------------------------------------------------------------------------------------------------------------------------
# ---------  GENERAL UTILITIES --------------
#-----------------------------------------------------------------------------------------------------------------------------------------------

# clear screen
clear
# or ctrl + l (lowercase L)

# delete all directories with a specified name
find ./shared* -name bin -type d
rm -rf `find ./shared* -name bin -type d`


# zip files
# zip {.zip-filename} {filename-to-compress}
zip 100160.MP.zip output/NOTICE_DOC1/received/100160.0000.MP[SD]*

# compress directory
tar -zcvf archive-name.tar.gz directory-name

# uncompress directory
tar -zxvf archive-name.tar.gz

bzip2 -d filename.bz2
# bz2, bz uncompress

# find top 10 biggest directories
du -sh * | sort -hr | head -n10

# diskspace in human readble form (in GB blocks)
df -h

# diskspace file system info in kilo bytes blocks (-m mega)
df -hk

# Hunt down disk space hogs with ducks
du -cks * | sort -rn | head
# create ducks alias
alias ducks='du -cks * | sort -rn | head'

# see on passent3 when space runs out
tpdev@mdzhlpass09:/tmp> pwd
/tmp
tpdev@mdzhlpass09:/tmp> du -sch .[!.]* * |sort -h

#diff side by side
diff -y file1 file2

# directory list files by time reverse and size with a pattern of file names
ls -ltrS 100200.0000.*

# list directory content sorted by size reverse date and long format (ll) in prod excluding the index (IDX) files that match a certain date
ls -Sltr --ignore '*.IDX.*' | grep 2017-01-16
# same as above but that match files that have 100200 in file name
ls -Sltr --ignore '*.IDX.*' | grep 100200 | grep 2017-01-16

# validate xml files
xmllint.exe --noout --schema RealDeliveryNoticeFile.xsd ./100200.0000.RDT1.IP022618.RRUEHT

#----------------------------------------------------------------------------------------------------------------------
# ---------  BUILD TOOLS COMMANDS --------------
#----------------------------------------------------------------------------------------------------------------------

# maven

# generate eclipse classpath resolve dependencies with exception of the listed projects - CLEAN UP CLASSPATH MANUALLY
# execute in root module director - e.g. batch, online, etc.
mvn eclipse:eclipse -pl biz-masterdata-job,tools-misc
# am - also make dependencies
mvn -pl :online-ear -am clean install -DskipTests

# update dependencies https://maven.apache.org/plugins/maven-dependency-plugin/resolve-mojo.html (double click link)
mvn dependency:resolve

# PASS maven build 	SHARED - needs profile. execute in shared directory!!
mvn clean install -pl shared-codevaluegen,shared-database,shared-dbdaogen,shared-dbtogen,shared-ogtopusgen,shared-xsdtogen -P full  -DskipTests

# PASS maven build TEST - needs profile. execute in test directory!!
mvn clean install -pl test-dbdaogen,test-dbtogen,test-integration -P full  -DskipTests

# p2x maven build projects
mvn -pl shared-wildfly,shared-metrics,online-alias-management,online-transaction-input clean install -DskipTests
mvn -pl shared-wildfly,shared-common,mgmtconsole-diagnosables,online-ear install -DskipTests


# P2XBO	maven build shared
mvn clean install -DskipTests -pl shared-wildfly,shared-dbtogen,shared-dbdaogen,shared-database

# mepo maven DB build command
mvn clean install -DskipTests -pl mepo-db,pass-mepo-model,mepo-shared

# mepo maven server build command
mvn clean install -DskipTests -pl mepo-db,mepo-shared,mepo-common,mepo-server,pass-mepo-model,pass-mepo-server

# mepo/pass server package/WAR including dependencies skip tests
mvn package -am -DskipTests -pl mepo-server,pass-mepo-server

# maven show active profiles
$ mvn help:active-profiles

# jenkins maven command shared
mvn -B -f /srv/jenkins/instances/pass/jobs/BR730-SHD/workspace/pom.xml clean deploy --fail-at-end -PdbUpdate,full,others -DbuildGen
# jenkins maven command shared
mvn -B -f /srv/jenkins/instances/pass/jobs/BR730-BAT/workspace/pom.xml -Pfull clean deploy

# debug maven plugins
# In IDE, add a Remote Configuration. Under Settings, set Transport: Socket, Debugger Mode: Attach, Host: localhost, Port: 8000 (default port of mvnDebug).
mvnDebug test -Dtest=com.example.MyTest

# maven exec java main class
mvn exec:java -Dexec.mainClass="com.telekurs.pass.batch.tools.testgui.PassTestGUI"


#----------------------------------------------------------------------------------------------------------------------
# ---------  VERSION CONTROL SYSTEM --------------
#----------------------------------------------------------------------------------------------------------------------

#****************************************************************************
# GIT
#****************************************************************************

#--------------------- basics -----------------------------------------------
# gitolite cloning project soon obsolete
git clone tpdev@passent3:[yourRepo]
# bitbucket clone
git clone ssh://git@stash.six-group.net:22/acqbo/<repo-name>.git

# list remote handles
git remote -v

# who details on remote by handle name
git remote show origin

# create remote branch. locally switch to new branch (devenv-1.0) and push to remote handle (gitlab)
git push gitlab devenv-1.0

# switch branch - develop is branch name
git checkout develop

# show log aka history in one line
git log --oneline --decorate
git log --oneline --decorate --all --graph

# stage files that have been modified and deleted, but new files you have not told Git about are not affected
git commit -a -m "message"

#--------------------- branches -----------------------------------------------
# https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging
# list local branches
git branch

# show all branches including remote
git branch -a

# show remote branches
git branch -r

# remove branch locally
git branch -d the_local_branch

# delete branch --delete --force
git branch -D the_local_branch

# remove/delete then branch remotely
git push origin :the_remote_branch
# OR other delete
git push <remote_name> --delete <branch_name>

# create branch
git branch branch_name
git checkout branch_name

# create branch and switch to it
git checkout -b branch_name

# merge checkout branch you want to merge changes into from hotfix branch, delete branch after merge if all work done
git checkout master
git merge hotfix
# OR one liner
git merge master hotfix
# then delete mergend branch
git branch -d hotfix

# update list of remote branches (prune origin)
 git remote prune origin

# delete remote branch
git push origin --delete <branch> 

# set url to pull and push
git remote set-url origin ssh://git@test-stash01.dev.six-group.net:22/acqbo/pass-tools.git
# list remotes 
git remote -v

# delete remotes
git remote rm remote_name

# clone example
git clone ssh://git@test-stash01.dev.six-group.net:22/acqbo/pass.git

#--------------------- files and directories --------
# add many files at once
git ls-files --modified | grep MF | xargs git add

# compare two branches
git diff branch_1..branch_2

# stash changes
git stash

# applied last stashed changes to repo
git stash apply

# show the stash stack
git stash list

# apply stashes in stack by reference. applies first stash in list
git stash apply stash@{1}

# To remove directories, run
# https://git-scm.com/docs/git-clean
git clean -f -d
git clean -fd
#To remove ignored files, run
git clean -f -X
git clean -fX
# To remove ignored and non-ignored files, run 
git clean -f -x
git clean -fx

# delete file or directory
git rm -r dir-name


#--------------------- undo --------
# https://www.atlassian.com/git/tutorials/undoing-changes 
git checkout
git revert
git reset --hard

# revert changes in current working directory
git checkout -- .

# reset hard to the state on the remote
git reset --hard origin/<branch_name>

# Remove all untracked files and directories. (`-f` is `force`, `-d` is `remove directories`)
git clean -fd

# removes all changes made to unstaged files in git status eg
git checkout -- *

#--------------------- commit push/pull ------------------
# devenv project
# gitlab remote
git remote add gitlab https://gitlab.com/toolsmith1/tools-devenv-setup.git
git push gitlab develop
git pull gitlab develop
# gitlist SIX remote
git push origin develop
git pull origin develop

# starte git gui
gitk

#--------------------- git config ------------------
# git configs
git config --global alias.add-commit '!git add -A && git commit'
git config --global alias.acommit '!git add -a && git commit'
git config --global --unset '<PROPERTY>'
git config --global --unset alias.add-commit
# set rebasing as default when pulling 
# rebase pulls commits in history order and applies local changes at the end
git config --global branch.autosetuprebase always

# config cache credentials
git config credential.helper cache
git config --global credential.helper 'cache --timeout=43200'
# unset again
git config --global --unset credential.helper



#****************************************************************************** 
# SVN 
#****************************************************************************** 
# find unversioned files
svn status | grep ^?
# find modfied files
svn status | grep M
# update repo
svn update
# commit all changes under directory where command is executed
svn commit -m "NO-ISSUE: build 75.0.03 and new dev-75.0 branch"

#----------------------------------------------------------------------------------------------------------------------
# DATABASE 
#----------------------------------------------------------------------------------------------------------------------
#DB URL
# IPASS_PROD@TIPA01S2      jdbc:oracle:thin:@misllpass04:1521:TIPA01S2
# TK3SY_IPASS_TRUNK@DCBO20 jdbc:oracle:thin:@mdzhlcbodb01:1521:DCBO20

# sqlplus / DB
sqlplus tk3sy_pass_trunk/tk3sy_pass_trunk@passent5/dpas20

# ping utility
tnsping pipa02
tnsping ppas03

# -- change passwords DB prod
sqlplus tk3sy/ChangeMe_2015@ppas03
sqlplus tk3sy/ChangeMe_2015@pipa02

# create link to another database (useful for comparing a build vs load)
#-- link to pass LOAD
create database link tk3sy_load connect to PASS_PROD identified by "TEKADI" using 'TPAS01S1'; 
# -- drop link after use
drop database link tk3sy_load; 

# db schemas on build
#jdbc:oracle:thin:@mdzhlcbodb01:1521:DCBO20

#db schemas load 1
#jdbc:oracle:thin:@mizhlpass23:1521:TPAS01S1


#******************************************************************************
# DOCKER DOCKER DOCKER
#******************************************************************************

# build image (Dockerfile must be in running directory)
docker build -t tk3sy:svn2git -f Dockerfile .
docker build --force-rm -t artifactory.six-group.net/acqbo/svn2git-0.2 -f Dockerfile .

# list available images
docker images | grep tk3sy:svn2git

# run container use -it for interactive terminal or -d for deamon process
docker run --name=tk3sy_svn2git --rm -it artifactory.six-group.net/acqbo/svn2git-0.2 bash
docker run --name=passIII_svn2git -d -v /home/tpdev/pass-svn/passIII/:/home/tpdev/svn-repo/:ro -v /home/tpdev/pass-git/:/home/tpdev/git-repo -v /home/tpdev/pass-svn/passIII-users.txt:/home/tpdev/authors.txt:ro -v /home/tpdev/svn2git-test.sh:/home/tpdev/svn2git-test.sh:ro artifactory.six-group.net/acqbo/svn2git-0.2
docker run --name=passIII_svn2git --rm -it -v /home/tpdev/pass-svn/passIII/:/home/tpdev/svn-repo/:ro -v /home/tpdev/pass-git/:/home/tpdev/git-repo -v /home/tpdev/pass-svn/passIII-users.txt:/home/tpdev/authors.txt:ro -v /home/tpdev/svn2git-test.sh:/home/tpdev/svn2git-test.sh:ro artifactory.six-group.net/acqbo/svn2git-0.2

# list running images
docker ps -a
 
docker ps -a | grep tk3sy
# show logs for a running container
docker logs [CONTAINER]

# list available images 
docker images

# login to container using bash
docker exec -it [CONTAINER] bash
  
# restart existing container 
docker start <CONTAINER ID>

# remove container from running containters list
docker rm [image_name]

# delete / remove a container from image repository list
#docker rmi [image_id]
docker rmi 066636657da7


