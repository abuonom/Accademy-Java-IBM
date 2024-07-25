import { HttpInterceptorFn } from '@angular/common/http';

export const loggerInterceptor: HttpInterceptorFn = (req, next) => {
	console.log(req.urlWithParams , req.method);
	return next(req);
};
