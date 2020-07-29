# Git Notes

> **VCS** - Version Control System tracks the history of changes on a project

> **DVCS** - Distributed VCS. Git is also a DVCS. Git doesn't need a constant connection to a central repository. Developers can work anywhere and colloborate asynchronously from any time zone.

> **Repository** - repo or git project. It encompasses the entire collection of files and folders associated with the project, along with each file's revision history. This revision history appears as snapshots called commits, and the commits exist as a linked list relationship and can be organized into multiple lines of development called branches

## Some very basic commands in Git are  
1. `git init` - initializes a brand new git repo. It adds a hidden subfolder that houses the internal data structures required for version control
2. `git clone` - creates a local copy of a project that already exists remotely
3. `git add` - stages a change. It is necessary to stage and take a snapshot of changes to include them in the project's history. This command performs staging. Any changes that are staged will become part of the next snapshot and a part of project's history
4. `git commit` - saves the snapshot to project history. commit functions like taking a photo. Anything that's been staged with git add will become part of this snapshot
5. `git status` - shows the status of changes as untracked, modified or staged
6. `git branch` - shows the branches being worked on locally
7. `git merge` - merges lines of development together. typically used to combine changes made on two distinct branches
8. `git pull` - updates the local line of development with updates from its remote counterpart.
9. `git push` - updates the remote repo with any commits made locally to a branch

## Some concepts of Git
### Git Branches
branches in git are really lightweight. They are simply pointers to a specific commit. So, follow the mantra `branch early & branch often`

### Merging
merging in git creates a special commit that has two parent pointers

### Rebasing
This is the second way of combining work between branches. Rebasing takes a set of commits, "copies" them & plops them down somewhere else.
Advantage of rebasing is that it can be used to make a nice linear sequence of commits. The commit/log history of the repository will be a lot cleaner if only rebasing is allowed
Rebasing can be performed in interactive fashion too using the `-i` flag. In the interactive session, we can reorder the commits, squash them into one, amending commit message etc.

### HEAD
symbolic name for the currently checked out commit. Normally HEAD points to a branch name.
HEAD can be detached which means just attaching it to a commit instead of a branch

### Relative Refs
They are used to move around the commit tree of our project. With relative refs, we can start somewhere(like the branch or HEAD) and work from there.
moving upwards one commit at a time with `^`
moving upwards a number of times with `~<num>`
Branch forcing is one of the major uses of relative refs. we can directly reassign a branch to a commit with the `-f` option  
`git branch -f master HEAD~3`

### Reversing changes
there are primarily two ways to undo changes - reset and revert
1. reset - this reverts changes by moving a branch reference backwards in time to older commit. reset works great for local branches on our local machine but this method of "rewriting" history doesn't work for remote branches that other devs are also using
2. revert - in order to reverse changes & share these reversed changes with others, we need to use revert. revert creates a new commit which introduces the changes that are reverse of the previous commit

### Cherry-pick
`git cherry-pick <commit_1> <commit_2> ....`  
It is a way of saying that we would like to copy a series of commits below our current location (HEAD)

### Git Tags
branches are easily mutated, often temporary and always changing. Tags are a way to permanently mark historical points in our project history.
Git tags permanently mark certain commits as "milestones" that we can reference like a branch.
tags never move as more commits are created. We can't checkout a tag and then complete work on that tag. Tags exist as anchors in the commit tree that designate certain spots.  
`git tag v1 commit_1`