package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TrinityFusion extends AttackSkill {
    public TrinityFusion() {
        this.setName("트리니티 퓨전");
        this.setDamage(360.0);
        this.setAttackCount(3L);
        this.setCooldown(13.0);
        this.setAddDamage(30L + 20);    // 트리니티-리인포스
        this.addIgnoreDefenseList(30L);
        this.addFinalDamage(1.6);   // 코어강화
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(900L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
    }
}
