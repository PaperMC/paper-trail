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
on startup then disables itself.
An alternate message is used if the server is
running Paper, but the version is too old to 
support the Paper plugin system.

### How to Use

Add the PaperMC repository to your build script
and shade `io.papermc:paper-trail:0.0.1-SNAPSHOT`
into your plugin.
It is recommended to relocate this dependency's
package to avoid conflicts.

To use Paper Trail, create a dummy
`plugin.yml` in your plugin with 
`io.papermc.papertrail.RequiresPaperPlugins`
as the "main" class. 
If you relocated the package, be sure to adjust 
the class path in the yml accordingly.

### License

Paper Trail is licensed under the MIT License.
See the LICENSE file for more information.
