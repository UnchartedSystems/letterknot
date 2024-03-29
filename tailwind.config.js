/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/**/*.cljs"],
  theme: {
    extend: {},
    container: {
      center: true,
    },
   },

  plugins: [
  require('@tailwindcss/typography'),
  require('@tailwindcss/forms'),
  ],

   corePlugins: {
    preflight: false,
   },
}
