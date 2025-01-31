package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FourSeasonsRamphant extends AttackSkill {
    public FourSeasonsRamphant() {
        this.setName("포 시즌 : 램펀트");
        this.setApplyFinalAttack(true);
        this.setAttackCount(7L * 2);
        this.setDamage(160.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.setRelatedSkill(new FourSeasonsRamphantAnnihilation());
    }
}
