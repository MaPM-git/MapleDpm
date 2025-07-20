package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulshatterSecretInfiniteBladesFlame extends AttackSkill {
    public SoulshatterSecretInfiniteBladesFlame() {
        this.setName("망혼검 절기 : 무량겁(불꽃)");
        this.setAttackCount(3L);
        this.setDamage(415.0);
        this.setDotDuration(5500L);
        this.setInterval(510L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);             // 망혼강림-리인포스
    }
}
