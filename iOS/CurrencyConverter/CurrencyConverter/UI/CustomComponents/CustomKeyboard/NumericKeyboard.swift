//
//  NumericKeyboard.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 15/12/2020.
//

import UIKit


class NumericKeyboard: UIView {
    
    private weak var target: UIKeyInput?
    private weak var delegate: NumericKeyboardDelegate?
    private var numericButtons: [DigitButton] = (0...9).map {
        let button = DigitButton(type: .system)
        button.digit = $0
        button.setTitle("\($0)", for: .normal)
        button.titleLabel?.font = .preferredFont(forTextStyle: .largeTitle)
        button.setTitleColor(.black, for: .normal)
        button.layer.borderWidth = 0.5
        button.layer.borderColor = UIColor.darkGray.cgColor
        button.accessibilityTraits = [.keyboardKey]
        button.addTarget(self, action: #selector(didTapDigitButton(_:)), for: .touchUpInside)
        return button
    }
    private var deleteButton: UIButton = {
        let button = UIButton(type: .system)
        button.setTitle("⌫", for: .normal)
        button.titleLabel?.font = .preferredFont(forTextStyle: .largeTitle)
        button.setTitleColor(.black, for: .normal)
        button.layer.borderWidth = 0.5
        button.layer.borderColor = UIColor.darkGray.cgColor
        button.accessibilityTraits = [.keyboardKey]
        button.accessibilityLabel = "Delete"
        button.addTarget(self, action: #selector(didTapDeleteButton(_:)), for: .touchUpInside)
        return button
    }()
    private var clrButton: UIButton = {
        let button = UIButton(type: .system)
        button.setTitle("CLR", for: .normal)
        button.titleLabel?.font = .preferredFont(forTextStyle: .largeTitle)
        button.setTitleColor(.black, for: .normal)
        button.layer.borderWidth = 0.5
        button.layer.borderColor = UIColor.darkGray.cgColor
        button.accessibilityTraits = [.keyboardKey]
        button.addTarget(self, action: #selector(didTapCLRButton(_:)), for: .touchUpInside)
        return button
    }()
    private var convertButton: UIButton = {
        let button = UIButton(type: .system)
        button.setTitle("Convert", for: .normal)
        button.titleLabel?.font = .preferredFont(forTextStyle: .largeTitle)
        button.setTitleColor(.black, for: .normal)
        button.layer.borderWidth = 0.5
        button.layer.borderColor = UIColor.darkGray.cgColor
        button.accessibilityTraits = [.keyboardKey]
        button.addTarget(self, action: #selector(didTapConvertButton(_:)), for: .touchUpInside)
        return button
    }()

    init(target: UIKeyInput, delegate: NumericKeyboardDelegate) {
        self.target = target
        self.delegate = delegate
        super.init(frame: .zero)
        configure()
    }

    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}

// MARK: - Actions

extension NumericKeyboard {
    
    @objc private func didTapDigitButton(_ sender: DigitButton) {
        target?.insertText("\(sender.digit)")
    }

    @objc private func didTapCLRButton(_ sender: DigitButton) {
        while ((target?.hasText) == true) {
            target?.deleteBackward()
        }
    }
    
    @objc private func didTapConvertButton(_ sender: DigitButton) {
        delegate?.didTapConvert()
    }

    @objc private func didTapDeleteButton(_ sender: DigitButton) {
        target?.deleteBackward()
    }
}

// MARK: - Private initial configuration methods

private extension NumericKeyboard {
   
    private func configure() {
        autoresizingMask = [.flexibleWidth, .flexibleHeight]
        addButtons()
    }

    private func addButtons() {
        let stackView = createStackView(axis: .vertical)
        var subStackView: UIStackView!
        stackView.frame = bounds
        stackView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
        addSubview(stackView)
        for row in 0 ..< 3 {
            subStackView = createStackView(axis: .horizontal)
            stackView.addArrangedSubview(subStackView)
            for column in 0 ..< 3 {
                subStackView.addArrangedSubview(numericButtons[row * 3 + column + 1])
            }
        }
        subStackView = createStackView(axis: .horizontal)
        stackView.addArrangedSubview(subStackView)
        subStackView.addArrangedSubview(clrButton)
        subStackView.addArrangedSubview(numericButtons[0])
        subStackView.addArrangedSubview(deleteButton)
        stackView.addArrangedSubview(convertButton)
    }

    private func createStackView(axis: NSLayoutConstraint.Axis) -> UIStackView {
        let stackView = UIStackView()
        stackView.axis = axis
        stackView.alignment = .fill
        stackView.distribution = .fillEqually
        return stackView
    }
}
