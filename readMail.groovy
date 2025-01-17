def emailTemplate = "resources/componentRegistrationEmailTemplate.html"
def templateContent = readFile file: emailTemplate
                        
                templateContent = templateContent.replace("APP_COMPONENT", "${appComponent}")
                                .replaceAll("APPLICATION_COMPONENT_WORKSPACE","${dbAppComponent.weburl}" )
                                    .replaceAll("APP_CODE", "${dbAppComponent.code}")
                                    .replaceAll("APPLICATION_CODE_WORKSPACE", "${dbAppCode.weburl}")
                                    .replaceAll("APPLICATION_DESIGNER", "${dbAppCode.designer}")           
                                    .replaceAll("SECURITY_CODE", "${dbAppComponent.securitycode}")
                                    .replaceAll("OWNER_SQUAD", "${ownerSquad}")
                    
                    emailext to: "${loggedOnUser.email};" + "cc:" + "${ccMailId}", body: """<p>Hi ${loggedOnUser.name},</p>
                    ${templateContent}""",subject: emailSubject, mimeType: 'text/html'
