# Shipkit Bitrise Example

[![Build Status](https://app.bitrise.io/app/33ba54b97388ce69/status.svg?token=odnBPFdi3PoD64RkUYXCEw&branch=master)](https://app.bitrise.io/app/33ba54b97388ce69)
[![Bintray](https://img.shields.io/badge/Bintray-browse-blue.svg)](https://bintray.com/shipkit-bootstrap/bootstrap/maven/#files/com%2Fgithub%2Fmstachniuk%2Fshipkit-bitrise-example)

This project shows, how to configure [Shipkit](http://shipkit.org) to use with [Bitrise.io](https://www.bitrise.io/).

## Differences Travis-CI vs Bitrise

Shipkit uses [Travis-CI](https://travis-ci.org/) as a CI (Continuous Integration) build system. 
Shipkit reads a few environment variables:

- `TRAVIS_PULL_REQUEST` - is set to the pull request number if the current job is a pull request build, or `false` if it’s not.
- `TRAVIS_BRANCH` - for push builds, or builds not triggered by a pull request, this is the name of the branch. 
For builds triggered by a pull request this is the name of the branch targeted by the pull request.
Reading branch name using git command doesn't work on Travis because Travis checkout detached HEAD. 
- `TRAVIS_COMMIT_MESSAGE` - The commit subject and body, unwrapped. 
Needed to check if merge commit contains [ci skip] or [ci skip-release] or [ci skip-compare-publications] flag.

More info: https://docs.travis-ci.com/user/environment-variables/

If you like to use Shipkit on Bitrise, or any other CI build system, you need to configure those variables.
Example for Bitrise:

```bash
envman add --key TRAVIS_PULL_REQUEST --value "${PR}"
envman add --key TRAVIS_BRANCH --value "${BITRISE_GIT_BRANCH}"
envman add --key TRAVIS_COMMIT_MESSAGE --value "${BITRISE_GIT_MESSAGE}"
```   

More info:
https://devcenter.bitrise.io/builds/available-environment-variables/

You can also check [bitrise.yml](bitrise.yml) for full setup.
