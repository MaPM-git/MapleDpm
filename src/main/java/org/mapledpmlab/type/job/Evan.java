package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.equipment.DragonWeapon;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class Evan extends Job {

    public Evan() {
        // 기본
        super();
        this.setName("에반");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addMagic((long) (406 + 250 + 72 + 276));
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        this.addMagicP(3L);

        // 보조
        this.addMainStat((long) (10 + 80 + 75));
        this.addSubStat(75L);
        this.addAtt(45L);
        this.addMagic((long) (1 + 45));
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);

        // 0차
        this.addMagic(10L);             // 계승된 의지
        this.addMainStat(10L);
        this.addSubStat(10L);

        // 1차
        this.addMagic(20L);             // 링크드 매직

        // 2차
        this.addMainStat(20L);          // 매직 액셀레이션
        this.addMainStat(40L);          // 하이 위즈덤
        this.addCriticalP(15.0);        // 스펠 마스터리
        this.addMagic(10L);

        // 3차
        this.addProperty(10L);          // 엘리멘탈 리셋
        this.addFinalDamage(1.17);
        this.addCriticalP(30.0);        // 크리티컬 매직
        this.addCriticalDamage(20.0);
        this.addFinalDamage(1.3);       // 매직 앰플리케이션
        this.addIgnoreDefenseList(20L);  // 드래곤 포텐셜

        // 4차
        this.addMagic(56L);             // 오닉스의 축복
        this.addMagic(31L);             // 매직 마스터리
        this.addCriticalDamage(20.0);
        this.addMagicP(31L);            // 드래곤 퓨리
        this.addBossDamage(21L);        // 하이 드래곤 포텐셜

        // 5차
        this.addMagic(35L);             // 스파이럴 오브 마나

        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new IntUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addDamage(20L);            // 교감
    }

    public void addTotal(JobType jobType) {
        super.addTotal(jobType);
        DragonWeapon dragonWeapon = new DragonWeapon();
        this.addMainStat(dragonWeapon.getMainStat());
        this.addMagic(dragonWeapon.getMagic());
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
