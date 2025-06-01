import {
	ApplicationConfig,
	importProvidersFrom,
	provideZoneChangeDetection,
} from '@angular/core';
import {
	provideClientHydration,
	withEventReplay,
} from '@angular/platform-browser';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';
import { ApiModule, Configuration } from './api';
import { environment } from '../environments/environment';

export const appConfig: ApplicationConfig = {
	providers: [
		provideHttpClient(), // ✅ Required for HttpClient
		provideZoneChangeDetection({ eventCoalescing: true }),
		provideRouter(routes),
		provideClientHydration(withEventReplay()),
		importProvidersFrom(
			ApiModule.forRoot(
				() => new Configuration({ basePath: environment.apiBasePath })
			)
		),
	],
};
