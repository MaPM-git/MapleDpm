package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.equipment.DragonWeapon;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class Evan2Continuous extends Job {

    public Evan2Continuous() {
        // 기본
        super();
        this.setName("에반(2초, 컨티)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

        this.setAscentDamage(2413290.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addMagic((long) (406 + 250 + 72 + 276));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        passive.addMagicP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat((long) (10 + 80 + 75));
        passive.addSubStat(75L);
        passive.addAtt(45L);
        passive.addMagic((long) (1 + 45));
        //passive.addBossDamage(70L);
        //passive.addMagicP(9L);
        passive.addBossDamage(30L);
        passive.addMagicP(21L);
        passive.addMagicP(21L);
        getPassiveList().add(passive);

        // 0차
        passive = new Common();
        passive.setDescription("계승된 의지");
        passive.addMagic(10L);
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("링크드 매직");
        passive.addMagic(20L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("매직 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("하이 위즈덤");
        passive.addMainStat(40L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스펠 마스터리");
        passive.addCriticalP(15.0);
        passive.addMagic(10L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("엘리멘탈 리셋");
        passive.addProperty(10L);
        passive.addFinalDamage(1.17);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("크리티컬 매직");
        passive.addCriticalP(30.0);
        passive.addCriticalDamage(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("매직 앰플리케이션");
        passive.addFinalDamage(1.3);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("드래곤 포텐셜");
        passive.addIgnoreDefenseList(20L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("오닉스의 축복");
        passive.addMagic(56L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("매직 마스터리");
        passive.addMagic(31L);
        passive.addCriticalDamage(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("드래곤 퓨리");
        passive.addMagicP(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("하이 드래곤 포텐셜");
        passive.addBossDamage(21L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("스파이럴 오브 마나");
        passive.addMagic(35L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(0L);
        this.addMainStat(13L);
        this.addSubStat(-5L);

        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new ArtifactNormal());
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

        Common doping = new Common();
        doping.setDescription("교감");
        doping.addDamage(20L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("매직 마스터리(콜렉터의 영약)");
        doping.addMagic(2L);
        doping.addCriticalDamage(1.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("드래곤 퓨리(콜렉터의 영약)");
        doping.addMagicP(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("하이 드래곤 포텐셜(콜렉터의 영약)");
        doping.addBossDamage(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("오닉스의 축복(콜렉터의 영약)");
        doping.addMagic(-40L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
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
