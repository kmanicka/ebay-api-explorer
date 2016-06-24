# eBay Starter App and API Explorer

A starter app for building application based on eBay Shopping and Trading APIs. Its based on PlayFramework 1.4.1 and ready to be deployed in Heroku.

## Key Features
* Basic templet page outlining key eBay flows. (Home Page, View Item, Search, MyeBay)
* Integrated with eBay Signin
* Shopping and Trading API Explorer
* Support for Sandbox and Production
* Externalized configuration for easy deployment

See it in action at  [ebay-api-explorer.herokuapp.com](https://ebay-api-explorer.herokuapp.com/)

## Build Status
[ ![Codeship Status for kmanicka/ebay-api-explorer](https://codeship.com/projects/e21d7bd0-ae87-0133-6578-6624307c89c5/status?branch=master)](https://codeship.com/projects/132388)


## Deploy your own copy to Heroku
[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/kmanicka/ebay-api-explorer/tree/master)


## Configurations

Developers should register in [eBay Developer Portal](https://go.developer.ebay.com/) and generate necessary credentials. 
* APPID
* DEVID
* CERTID
* RUNAME

Apart from that following configuration is used to determine if the applicaiton talks to Sandbox or Production eBay APIs
* SANDBOX   (TRUE / FALSE)

## Versions

### Version 0.9 (06/22/2016)
* Basic View Item Page 

### Version 0.8 (06/22/2016)
* Basic eBay Home Page 

###Version 0.7 (06/21/2016)
* Template eBay Page

### Version 0.6 (06/20/2016)
* Added a settings page to view the current settings

### Version 0.5
* Login with eBay Trading API
* Cleanup Env Variables, Seperate instance for Sandbox and Production

### Version 0.4
* Made Tabbed API exploration Page. Separate Input and Output Tab 

### Version 0.3
* GetUserProfile Shopping API and Page
* GetSingleItem Shopping API and Page
* Externalized the Play Application Secret

### Version 0.2
* eBay API Setup
* GeteBayTime Shopping Api
* GeteBayOfficialTime Shopping Api
* Settings Page

### Version 0.1
* Basic Skeleton of the application
* Deployment to Heroku
* CI via CodeShip.
* Heroku Pipeline Setup 


### Contact 
[@Kumaresan](https://twitter.com/kumaresan)
