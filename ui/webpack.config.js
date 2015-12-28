/**
 * Created by tk3sy on 16.12.2015.
 */

module.exports = {
    entry: './public/javascripts/app.ts',
    output: {
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['', '.webpack.js', '.web.js', '.ts', '.js']
    },
    module: {
        loaders: [
            { test: /\.ts$/, loader: 'ts-loader' }
        ]
    }
}