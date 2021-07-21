import { createTownList } from './controllers/townController.js';
import {form} from './util/domElements.js';

form.addEventListener('submit', createTownList);