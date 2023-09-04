package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class OrbitalFlameReinforce extends AttackSkill {
    public OrbitalFlameReinforce() {
        this.setName("오비탈 플레임(강화)");
        this.setDamage(945.0 - 90);
        this.setDelay(210L);
        this.setAttackCount(2L + 1);        // 오비탈 플레임-스플릿 어택
        this.addIgnoreDefenseList(20L);     // 오비탈 플레임-이그노어 가드
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
