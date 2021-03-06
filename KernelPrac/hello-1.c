/*  
 *  hello-1.c - The simplest kernel module.
 */
#include <linux/module.h>	/* Needed by all modules */
#include <linux/kernel.h>	/* Needed for KERN_INFO */

static int hello_init(void)
{
	//More about the MACROS being used can be found below:
	//https://elinux.org/Debugging_by_printing
	printk(KERN_INFO "Hello world 1.\n");

	/* 
	 * A non 0 return means init_module failed; module can't be loaded. 
	 */
	return 0;
}

static void hello_exit(void)
{
	printk(KERN_INFO "Goodbye world 1.\n");
}

module_init(hello_init);
module_exit(hello_exit);
