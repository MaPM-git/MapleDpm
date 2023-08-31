package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PhotonShockwave extends AttackSkill {
    public PhotonShockwave() {
        this.setName("빛의 충격파");
        this.setAttackCount(5L);
        this.setDamage(350.0 + 257);    // 어드밴스드 오펜시브 디펜스
        this.setCooldown(10.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
