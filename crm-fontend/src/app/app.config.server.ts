import { mergeApplicationConfig, ApplicationConfig } from '@angular/core';
import { provideServerRendering } from '@angular/platform-server';
import { provideServerRouting } from '@angular/ssr';
import { appConfig } from './app.config';
import { serverRoutes } from './app.routes.server';
import { HttpClientModule } from '@angular/common/http';

const serverConfig: ApplicationConfig = {
  providers: [
    HttpClientModule,
    provideServerRendering(),
    provideServerRouting(serverRoutes),
  ],
};

export const config = mergeApplicationConfig(appConfig, serverConfig);
