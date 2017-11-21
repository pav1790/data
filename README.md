# Event Data Tracker

This project uses the [Play Framework](https://playframework.com/documentation) with java.
Recommended IDE is Intelli J

## Architecture
Events are created and stored to allow customers to register as a participant in the event.




## Database setup 
### macOS
First install PostgreSQL database 

    brew install postgresql@9.6

To have launchd start postgresql@9.6 now and restart at login:
  
    brew services start postgresql@9.6

Or, if you don't want/need a background service you can just run:

    pg_ctl -D /usr/local/var/postgresql@9.6 start
  
  
Might need to do:

If you need to have this software first in your PATH run:
  
    echo 'export PATH="/usr/local/opt/postgresql@9.6/bin:$PATH"' >> ~/.bash_profile

For compilers to find this software you may need to set:
    
    LDFLAGS:  -L/usr/local/opt/postgresql@9.6/lib
    CPPFLAGS: -I/usr/local/opt/postgresql@9.6/include
    
    
Must do:
If you run `psql` and get the response
    
    FATAL:  database "username" does not exist

Run the `createdb` and try `psql` again to make sure it works
    
Next create a database `create database data;` and verify it was added with `\l` 



