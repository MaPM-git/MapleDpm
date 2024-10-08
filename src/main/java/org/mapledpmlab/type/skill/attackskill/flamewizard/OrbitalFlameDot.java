package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class OrbitalFlameDot extends AttackSkill {
    public OrbitalFlameDot() {
        this.setName("오비탈 플레임(불길)");
        this.setDamage(620.0 - 90);
        this.setAttackCount(9L + 1);        // 오비탈 플레임-스플릿 어택
        this.setCooldown(15.0);
        this.addIgnoreDefenseList(20L);     // 오비탈 플레임-이그노어 가드
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(500L);
        this.getMultiAttackInfo().add(500L);
        this.getMultiAttackInfo().add(500L);
    }
}
