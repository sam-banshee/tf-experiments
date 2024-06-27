import jenkins.model.*

pluginList = [
	"ant",
	"antisamy-markup-formatter",
	"apache-httpcomponents-client-4-api",
	"asm-api",
	"bootstrap5-api",
	"bouncycastle-api",
	"branch-api",
	"build-timeout",
	"caffeine-api",
	"checks-api",
	"cloudbees-folder",
	"commons-lang3-api",
	"commons-text-api",
	"configuration-as-code",
	"credentials",
	"credentials-binding",
	"dark-theme",
	"display-url-api",
	"durable-task",
	"echarts-api",
	"eddsa-api",
	"email-ext",
	"font-awesome-api",
	"git",
	"git-client",
	"github",
	"github-api",
	"github-branch-source",
	"gradle",
	"gson-api",
	"instance-identity",
	"ionicons-api",
	"jackson2-api",
	"jakarta-activation-api",
	"jakarta-mail-api",
	"javax-activation-api",
	"javax-mail-api",
	"jaxb",
	"jjwt-api",
	"job-dsl",
	"joda-time-api",
	"jquery3-api",
	"json-api",
	"json-path-api",
	"junit",
	"ldap",
	"mailer",
	"matrix-auth",
	"matrix-project",
	"metrics",
	"mina-sshd-api-common",
	"mina-sshd-api-core",
	"okhttp-api",
	"pipeline-build-step",
	"pipeline-github-lib",
	"pipeline-graph-analysis",
	"pipeline-graph-view",
	"pipeline-groovy-lib",
	"pipeline-input-step",
	"pipeline-milestone-step",
	"pipeline-model-api",
	"pipeline-model-definition",
	"pipeline-model-extensions",
	"pipeline-stage-step",
	"pipeline-stage-tags-metadata",
	"plain-credentials",
	"plugin-util-api",
	"resource-disposer",
	"scm-api",
	"script-security",
	"snakeyaml-api",
	"ssh-credentials",
	"ssh-slaves",
	"structs",
	"theme-manager",
	"timestamper",
	"token-macro",
	"trilead-api",
	"variant",
	"workflow-aggregator",
	"workflow-api",
	"workflow-basic-steps",
	"workflow-cps",
	"workflow-durable-task-step",
	"workflow-job",
	"workflow-multibranch",
	"workflow-scm-step",
	"workflow-step-api",
	"workflow-support",
	"ws-cleanup",
]

//println("${pluginList}")

instance = Jenkins.get()

pluginManager = instance.getPluginManager()
pluginManager.doCheckUpdatesServer()
pluginInstallJobs = pluginManager.install(pluginList, true)
updateCenter = instance.getUpdateCenter()

pluginInstallJobs.each {
	println("${it.get()}")
}

instance.save()
if (updateCenter.isRestartRequiredForCompletion()) {
	instance.doSafeRestart(null)
}
