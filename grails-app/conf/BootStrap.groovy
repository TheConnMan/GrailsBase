import com.theconnman.Role
import com.theconnman.User
import com.theconnman.UserRole

class BootStrap {
	
	def createUser(name, role) {
		User me = new User(username: name).save()
		UserRole.create(me, role, true)
	}

    def init = { servletContext ->
		println 'Bootstrapping'
		def adminRole = new Role(authority: "ROLE_ADMIN").save()
		def userRole = new Role(authority: "ROLE_USER").save()
		createUser('TheConnMan', adminRole);
    }

    def destroy = {
		
    }
}
