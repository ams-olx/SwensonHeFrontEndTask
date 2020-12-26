//
//  Dialogs.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import UIKit.UIAlertController
import UIKit.UIViewController

class Dialogs {

    private var alertController: UIAlertController?
    private weak var viewController: UIViewController?
    public typealias ToDoClosure = (_ title: String, _ details: String) -> Void

    func showDialog(viewController: UIViewController, title: String = "message".localized(), message: String) {
        self.viewController = viewController
        alertController = UIAlertController(title: title, message: message, preferredStyle: .alert)
        alertController!.addAction(UIAlertAction(title: "ok".localized(), style: .default, handler: nil))
        viewController.present(alertController!, animated: true, completion: nil)
    }

    func showLoading(viewController: UIViewController) {
        self.viewController = viewController
        self.alertController = UIAlertController(title: nil,
                                            message: "loading".localized(),
                                            preferredStyle: .alert)
        let loadingIndicator = UIActivityIndicatorView(frame: CGRect(x: 10, y: 5, width: 50, height: 50))
        loadingIndicator.hidesWhenStopped = true
        if #available(iOS 13.0, *) { loadingIndicator.style = .medium }
        else { loadingIndicator.style = .gray }
        loadingIndicator.startAnimating()
        self.alertController!.view.addSubview(loadingIndicator)
        self.viewController?.present(alertController!, animated: true, completion: nil)
    }
    
    private func hideAletDialog() {
        self.viewController?.dismiss(animated: true, completion: nil)
        self.viewController = nil
    }
    
    func hideLoading() {
        hideDialog()
    }

    func hideDialog() {
        hideAletDialog()
    }
}
