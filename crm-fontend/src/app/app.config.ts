import {
  ApplicationConfig,
  importProvidersFrom,
  provideZoneChangeDetection,
} from '@angular/core';
import { provideRouter } from '@angular/router';
// import { ApiModule, Configuration } from './app/api-client'; // Adjust path if needed
import { routes } from './app.routes';
import {
  provideClientHydration,
  withEventReplay,
} from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { ApiModule, Configuration } from './api';

export const appConfig: ApplicationConfig = {
  providers: [
    provideHttpClient(), // ✅ Required for HttpClient
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideClientHydration(withEventReplay()),
    importProvidersFrom(
      ApiModule.forRoot(
        () => new Configuration({ basePath: 'http://localhost:8080' }) // your Spring Boot backend URL
      )
    ),
  ],
};
