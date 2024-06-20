# Paper Trail

**Paper Trail** is a helper library for 
notifying users of legacy server software 
that a plugin requires Paper.
The main use case for this library
is for plugins that utilize the new
Paper plugin system (`paper-plugin.yml`)
and do not support the legacy plugin system
(`plugin.yml`).

Paper Trail offers a simple way to notify users
that they need to upgrade to Paper by providing
a stub `JavaPlugin` that prints a helpful message
on startup and then disables itself.
An alternate message is used if the server is
running Paper, but the version is too old to 
support the Paper plugin system.

### How to Use

Add the PaperMC repository (`https://repo.papermc.io/repository/maven-public/`) to your build script
and shade `io.papermc:paper-trail:1.0.0`
into your plugin.
It is recommended to relocate the `io.papermc.papertrail`
package to avoid conflicts.

To use Paper Trail, add a
`plugin.yml` to your plugin with 
`io.papermc.papertrail.RequiresPaperPlugins`
as the "main" class. 
If you relocated the package, be sure to adjust 
the class name in the yaml accordingly.

### License

Paper Trail is licensed under the MIT License.
See the [LICENSE](LICENSE) file for more information.
