package com.xpdrops.predictedhit.npcswithscalingbonus.cox;

public class Tekton extends CoXNPC
{
	private int scaledPartySize = 1;

	public Tekton(int hp, int att, int str, int mage, int range, int def, int offensiveAtt, int offensiveStr, int defensiveStab, int defensiveSlash, int defensiveCrush, int defensiveMage, int defensiveRange)
	{
		super(hp, att, str, mage, range, def, offensiveAtt, offensiveStr, defensiveStab, defensiveSlash, defensiveCrush, defensiveMage, defensiveRange);
	}

	@Override
	protected double calculateHpScaling(int scaledPartySize, int playersInRaid)
	{
		this.scaledPartySize = scaledPartySize;
		return super.calculateHpScaling(scaledPartySize, playersInRaid);
	}

	@Override
	protected double cmDefenceMultiplier()
	{
		return scaledPartySize < 4 ? 1.2 : 1.35;
	}

	@Override
	protected double cmMagicMultiplier()
	{
		return 1.2;
	}
}
