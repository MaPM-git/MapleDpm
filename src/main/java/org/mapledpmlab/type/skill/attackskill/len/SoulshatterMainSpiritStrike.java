package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulshatterMainSpiritStrike extends AttackSkill {
    public SoulshatterMainSpiritStrike() {
        this.setName("망혼검 본초 : 영격");
        this.setAttackCount(4L);
        this.setDamage(1210.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);    // 망혼검 본초 : 영격-리인포스
    }
}
