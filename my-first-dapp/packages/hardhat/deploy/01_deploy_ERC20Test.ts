import { HardhatRuntimeEnvironment } from "hardhat/types";
import { DeployFunction } from "hardhat-deploy/types";
import { Contract } from "ethers";

/**
 * Deploys a contract named "ERC20Test" using the deployer account
 *
 * @param hre HardhatRuntimeEnvironment object.
 */
const deployERC20Test: DeployFunction = async function (hre: HardhatRuntimeEnvironment) {
  const { deployer } = await hre.getNamedAccounts();
  const { deploy } = hre.deployments;

  await deploy("ERC20Test", {
    from: deployer,
    args: [],
    log: true,
    autoMine: true,
  });

  // Get the deployed contract to interact with it after deploying.
  const erc20Test = await hre.ethers.getContract<Contract>("ERC20Test", deployer);
  console.log("🪙 Token name:", await erc20Test.name());
  console.log("🪙 Token symbol:", await erc20Test.symbol());
  console.log("🪙 Deployer address:", deployer);

  const initialSupply = hre.ethers.parseEther("1000000");
  await erc20Test.mint(deployer, initialSupply);
  console.log("🪙 Minted initial supply:", hre.ethers.formatEther(initialSupply), "tokens to", deployer);
  console.log("🪙 Deployer balance:", hre.ethers.formatEther(await erc20Test.balanceOf(deployer)));

  // 自动授权 deployer 可以使用 transferFrom
  const maxApproval = hre.ethers.MaxUint256; // 或使用具体金额
  await erc20Test.approve(deployer, maxApproval);
  console.log("✅ Approved unlimited amount for deployer to use transferFrom");
};

export default deployERC20Test;

deployERC20Test.tags = ["ERC20LSR202330550941"];
